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


    public MessageResponseUploadDTO uploadFromFile(Long solutionID, MultipartFile multipartFile, String cookie) {
        SolutionDTO2 solutionDTO2 = solutionsService.getSolution2ById(solutionID);
        String fileName = fileService.getName(multipartFile);
        File file = fileService.getOutputStream(fileName, multipartFile);
        testingApp(solutionDTO2, fileName, file, cookie);
        return new MessageResponseUploadDTO(0, "End test");
    }

//    private void upload(Long solutionID, InputStream file) {
//        String fileLocation = setSolutionFinish(solutionID);
//        InputStream tarInputStream = new TarArchiveInputStream(file);
//        connectDockerService.uploadFile(tarInputStream,
//                configDockerService.getPathFile() + fileLocation,
//                '/' + solutionID.toString());
//    }

//    private String setSolutionFinish(Long solutionID) {
//        Solution solution = solutionRepository.findById(solutionID)
//                .orElseThrow(() -> new EntityExistsException("Solution not exist"));
//        return '/' + solution.getSolutionID().toString();
//    }

    private void testingApp(SolutionDTO2 solutionDTO2, String fileName, File file, String cookie) {

        List<ResultDTO2> resultDTO2List;
        List<TestDTO> testDetailsDtoList = testsService.getAllTestsByTaskID(solutionDTO2.getTaskID());

        String nameContainer = configDockerService
                .getPrefixContainer() +
                solutionDTO2.getSolutionID().toString() +
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

        resultDTO2List = consoleApp(dockerClient, id, fileNameWithoutExtension, testDetailsDtoList, cookie);

        resultsService.saveResultsForSolution(resultDTO2List, solutionDTO2.getSolutionID());

        int result = 0;
        for (ResultDTO2 resultDTO2: resultDTO2List) {
            if(resultDTO2.getIsCorrect()) result++;
        }
        solutionDTO2.setResultsPoints((result*100)/resultDTO2List.size());
        solutionsService.updateOffer(solutionDTO2);
        dockerApiService.deleteContainer(dockerClient, id);
    }

    private List<ResultDTO2> consoleApp(DockerClient dockerClient, String id, String fileName, List<TestDTO> testDetailsDtoList, String cookie) {
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
                        .equals(StringUtils.deleteWhitespace(test.getOutputData())), runResult, cookie, test.getTestID()));
            }
        } catch (Exception ignored) {

        }
        return newResults;
    }

}