package designpatternsbackend.xapi.controllers;

import designpatternsbackend.xapi.dto.SolutionDTO;
import designpatternsbackend.xapi.services.SolutionsService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/solutions")
@AllArgsConstructor
public class SolutionsController {
    private final SolutionsService solutionsService;

    @GetMapping
    public ResponseEntity<List<SolutionDTO>> getAllSolutions(){
        return ResponseEntity.ok(solutionsService.getAllSolutions());
    }

    @GetMapping("/task/{id}")
    public ResponseEntity<List<SolutionDTO>> getAllSolutionsByTask(@PathVariable Long id){
        return ResponseEntity.ok(solutionsService.getAllSolutionsByTaskID(id));
    }
}
