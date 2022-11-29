package designpatternsbackend.services;

import designpatternsbackend.dto.ResultDTO;
import designpatternsbackend.mapper.ResultsMapper;
import designpatternsbackend.repositories.ResultsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ResultsService {
    private final ResultsRepository resultsRepository;
    private final ResultsMapper resultsMapper;

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
}
