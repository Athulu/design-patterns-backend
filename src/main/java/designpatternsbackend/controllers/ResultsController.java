package designpatternsbackend.controllers;

import designpatternsbackend.dto.ResultDTO;
import designpatternsbackend.services.ResultsService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/results")
@AllArgsConstructor
public class ResultsController {
    private final ResultsService resultsService;

    @GetMapping("/id/{id}")
    public ResponseEntity<ResultDTO> getResult(@PathVariable Long id){
        return ResponseEntity.ok(resultsService.getResultById(id));
    }

    @GetMapping()
    public ResponseEntity<List<ResultDTO>> getAllResults(){
        return ResponseEntity.ok(resultsService.getAllResults());
    }

    @GetMapping("/solution/{id}")
    public ResponseEntity<List<ResultDTO>> getResultListBySolution(@PathVariable Long id){
        return ResponseEntity.ok(resultsService.getAllResultsBySolutionID(id));
    }

    @GetMapping("/test/{id}")
    public ResponseEntity<List<ResultDTO>> getResultListByTest(@PathVariable Long id){
        return ResponseEntity.ok(resultsService.getAllResultsByTestID(id));
    }
}
