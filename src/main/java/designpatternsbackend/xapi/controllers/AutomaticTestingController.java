package designpatternsbackend.xapi.controllers;

import designpatternsbackend.docker.AutomaticTestingService;
import designpatternsbackend.docker.DockerApiService;
import designpatternsbackend.docker.MessageResponseUploadDTO;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/testing")
@AllArgsConstructor
public class AutomaticTestingController {
    AutomaticTestingService automaticTestingService;
    DockerApiService dockerApiService;

    @PostMapping("/{id}")
    ResponseEntity<MessageResponseUploadDTO> upload(@PathVariable Long id, @RequestParam(value = "file") MultipartFile file, @RequestParam(value = "cookie") String cookie) {
        return ResponseEntity.ok().body(automaticTestingService.uploadFromFile(id, file, cookie));
    }
}
