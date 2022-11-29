package designpatternsbackend.docker;

import com.github.dockerjava.api.DockerClient;
import designpatternsbackend.xapi.dao.Solution;
import designpatternsbackend.xapi.dto.*;
import designpatternsbackend.xapi.repositories.SolutionsRepository;
import designpatternsbackend.xapi.services.ResultsService;
import designpatternsbackend.xapi.services.SolutionsService;
import designpatternsbackend.xapi.services.TasksService;
import designpatternsbackend.xapi.services.TestsService;
import lombok.AllArgsConstructor;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.EntityExistsException;
import java.io.*;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class AutomaticTestingService {
    final SolutionsRepository solutionRepository;
    final ConfigDockerService configDockerService;
    final ConfigCommandService connfigCommandService;
    final ConnectDockerService connectDockerService;
    final FileService fileService;
    final DockerApiService dockerApiService;
    final ResultsService resultsService;
    final TestsService testsService;
    final TasksService tasksService;
    final SolutionsService solutionsService;
    final CommandService commandService;


    public MessageResponseUploadDTO uploadFromFile(Long solutionID, MultipartFile multipartFile) {
        SolutionDTO2 solutionDTO2 = solutionsService.getSolution2ById(solutionID);
        String fileName = fileService.getName(multipartFile);
        File file = fileService.getOutputStream(fileName, multipartFile);
        testingApp(solutionDTO2, fileName, file);
        return new MessageResponseUploadDTO(0, "End test");
    }

//    private void upload(Long solutionID, InputStream file) {
//        String fileLocation = setSolutionFinish(solutionID);
//        InputStream tarInputStream = new TarArchiveInputStream(file);
//        connectDockerService.uploadFile(tarInputStream,
//                configDockerService.getPathFile() + fileLocation,
//                '/' + solutionID.toString());
//    }

    private String setSolutionFinish(Long solutionID) {
        Solution solution = solutionRepository.findById(solutionID)
                .orElseThrow(() -> new EntityExistsException("Solution not exist"));
        return '/' + solution.getSolutionID().toString();
    }

    private void testingApp(SolutionDTO2 solution, String fileName, File file) {

        List<ResultDTO2> newResults;
        List<TestDTO> testDetailsDtoList = testsService.getAllTestsByTaskID(solution.getTaskID());

        String nameContainer = configDockerService
                .getPrefixContainer() +
                solution.getSolutionID().toString() +
                "_" +
                LocalDateTime.now()
                        .atZone(ZoneId.systemDefault())
                        .toEpochSecond();

        DockerClient dockerClient = dockerApiService.getInstance();
        String id = dockerApiService.createContainer(dockerClient, nameContainer, connfigCommandService.getRunContainer());

        TarDTO tarDto = fileService.parseToTar(file);
        dockerApiService.copyToContainer(dockerClient, id, tarDto.getTargetStream(), "/");
        dockerApiService.startContainer(dockerClient, id);
        fileService.deleteFile(tarDto.getInitialFile());

        String fileNameWithoutExtension = fileName.replace(".java", "");

        newResults = consoleApp(dockerClient, id, fileNameWithoutExtension, testDetailsDtoList);


        resultsService.saveResultsForSolution(newResults, solution.getSolutionID());
        dockerApiService.deleteContainer(dockerClient, id);
    }

    private List<ResultDTO2> consoleApp(DockerClient dockerClient, String id, String fileName, List<TestDTO> testDetailsDtoList) {
        List<ResultDTO2> newResults = new ArrayList<>();
        try {
            for (TestDTO test : testDetailsDtoList) {
                String runResult = dockerApiService.execContainer(
                        dockerClient,
                        id,
                        commandService.runCommand(
                                fileName,
                                test.getInputData()),
                        45L
                );

                newResults.add(new ResultDTO2(StringUtils.deleteWhitespace(runResult)
                        .equals(StringUtils.deleteWhitespace(test.getOutputData())), runResult, test.getTestID()));
            }
        } catch (Exception ignored) {

        }
        return newResults;
    }

}