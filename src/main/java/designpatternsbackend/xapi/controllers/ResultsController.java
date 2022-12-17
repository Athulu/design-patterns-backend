package designpatternsbackend.xapi.controllers;

import designpatternsbackend.xapi.dto.ResultDTO;
import designpatternsbackend.xapi.dto.ResultDTO2;
import designpatternsbackend.xapi.services.ResultsService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin(origins = "http://localhost:8080")
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

    @PostMapping("/cookie")
    public ResponseEntity<List<ResultDTO2>> getResultListByTest(@RequestParam(value = "cookie") String cookie){
        return ResponseEntity.ok(resultsService.getAllResultsByCookie(cookie));
    }
}
