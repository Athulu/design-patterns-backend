package designpatternsbackend.xapi.controllers;

import designpatternsbackend.xapi.dto.TaskDTO;
import designpatternsbackend.xapi.services.TasksService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/tasks")
@AllArgsConstructor
public class TasksController {
    private final TasksService tasksService;

    @GetMapping
    public ResponseEntity<List<TaskDTO>> getAllTasks(){
        return ResponseEntity.ok(tasksService.getAllTasks());
    }
}
