package designpatternsbackend.services;

import designpatternsbackend.dto.SolutionDTO;
import designpatternsbackend.mapper.SolutionsMapper;
import designpatternsbackend.repositories.SolutionsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SolutionsService {
    private final SolutionsRepository solutionsRepository;
    private final SolutionsMapper solutionsMapper;
    public List<SolutionDTO> getAllSolutions(){
        return solutionsMapper.solutionsToSolutionsDTOList(solutionsRepository.findAll());
    }
    public List<SolutionDTO> getAllSolutionsByTaskID(Long id){
        return solutionsMapper.solutionsToSolutionsDTOList(solutionsRepository.findSolutionByTask_TaskID(id));
    }
}
