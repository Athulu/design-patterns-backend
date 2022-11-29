package designpatternsbackend.xapi.services;

import designpatternsbackend.xapi.dao.Result;
import designpatternsbackend.xapi.dao.Solution;
import designpatternsbackend.xapi.dto.ResultDTO2;
import designpatternsbackend.xapi.mapper.ResultDTO2Mapper;
import designpatternsbackend.xapi.repositories.ResultsRepository;
import designpatternsbackend.xapi.dto.ResultDTO;
import designpatternsbackend.xapi.mapper.ResultsMapper;
import designpatternsbackend.xapi.repositories.SolutionsRepository;
import designpatternsbackend.xapi.repositories.TestsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityExistsException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@AllArgsConstructor
public class ResultsService {
    private final ResultsRepository resultsRepository;
    private final ResultsMapper resultsMapper;
    private final SolutionsRepository solutionsRepository;
    private final TestsRepository testsRepository;

    public ResultDTO getResultById(Long id){
        return resultsMapper.resultToResultDTO(resultsRepository.findResultsByResultID(id));
    }

    public List<ResultDTO> getAllResults(){
        return resultsMapper.resultsToResultDTOList(resultsRepository.findAll());
    }
    public List<ResultDTO> getAllResultsBySolutionID(Long id){
        return resultsMapper.resultsToResultDTOList(resultsRepository.findResultsBySolution_SolutionID(id));
    }

    public List<ResultDTO> getAllResultsByTestID(Long id){
        return resultsMapper.resultsToResultDTOList(resultsRepository.findResultsByTest_TestID(id));
    }

    @Transactional
    public List<ResultDTO2> saveResultsForSolution(List<ResultDTO2> newResults, Long solutionId) {
        Optional<Solution> solution = solutionsRepository.findById(solutionId);
        List<Result> results = newResults.stream()
                .map(newResult -> createResult(newResult, solution)).toList();

        for (Result res: results) {
            if(res.getOutputData().length() > 200) res.setOutputData(res.getOutputData().substring(0,200));
        }
        return ResultDTO2Mapper.resultsToResultDTO2List(StreamSupport.stream(resultsRepository.saveAll(results).spliterator(), false)
                .collect(Collectors.toList()));
    }

    private Result createResult(ResultDTO2 newResult, Optional<Solution> solution) {
        Long testId = newResult.getTestID();
        Result result = new Result();
        result.setIsCorrect(newResult.getIsCorrect());
        result.setOutputData(newResult.getOutputData());
        result.setTest(testsRepository.findById(testId)
                .orElseThrow(() -> new EntityExistsException("Test with id " + testId + " does not exist!")));
        result.setSolution(solution.get());
        return result;
    }
}
