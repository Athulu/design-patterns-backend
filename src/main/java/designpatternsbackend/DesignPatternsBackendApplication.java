package designpatternsbackend;

import designpatternsbackend.docker.*;
import designpatternsbackend.xapi.repositories.SolutionsRepository;
import designpatternsbackend.xapi.services.ResultsService;
import designpatternsbackend.xapi.services.SolutionsService;
import designpatternsbackend.xapi.services.TasksService;
import designpatternsbackend.xapi.services.TestsService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DesignPatternsBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(DesignPatternsBackendApplication.class, args);

//        final ConfigDockerService configDockerService;
//        final ConfigCommandService configCommandService;
//        final ConnectDockerService connectDockerService;
//        final FileService fileService;
//        final DockerApiService dockerApiService;
//        final ResultsService resultsService;
//        final TestsService testsService;
//        final TasksService tasksService;
//        final SolutionsService solutionsService;
//        final CommandService commandService;
//
//        AutomatingTestingService aaa = new AutomatingTestingService(, configDockerService, configCommandService,
//                connectDockerService, fileService, dockerApiService, resultsService, testsService, tasksService, solutionsService,
//                commandService);
    }
}
