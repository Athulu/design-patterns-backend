package designpatternsbackend.xapi.controllers;

import designpatternsbackend.xapi.services.TestsService;
import designpatternsbackend.xapi.dto.TestDTO;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/tests")
@AllArgsConstructor
public class TestsController {
    private final TestsService testsService;

    @GetMapping
    public ResponseEntity<List<TestDTO>> getAllTests(){
        return ResponseEntity.ok(testsService.getAllTests());
    }

    @GetMapping("/task/{id}")
    public  ResponseEntity<List<TestDTO>> getAllTestsByTask(@PathVariable Long id){
        return ResponseEntity.ok(testsService.getAllTestsByTaskID(id));
    }
}
