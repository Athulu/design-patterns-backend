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
    }
}
