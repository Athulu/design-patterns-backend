package designpatternsbackend.xapi.services;

import designpatternsbackend.xapi.dao.Result;
import designpatternsbackend.xapi.dao.Solution;
import designpatternsbackend.xapi.dto.ResultDTO;
import designpatternsbackend.xapi.dto.ResultDTO2;
import designpatternsbackend.xapi.dto.SolutionDTO;
import designpatternsbackend.xapi.dto.SolutionDTO2;
import designpatternsbackend.xapi.mapper.ResultDTO2Mapper;
import designpatternsbackend.xapi.mapper.SolutionDTO2Mapper;
import designpatternsbackend.xapi.mapper.SolutionsMapper;
import designpatternsbackend.xapi.repositories.SolutionsRepository;
import designpatternsbackend.xapi.repositories.TasksRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SolutionsService {
    private final SolutionsRepository solutionsRepository;
    private final SolutionsMapper solutionsMapper;
    private final TasksRepository tasksRepository;

    public SolutionDTO getSolutionById(Long id){
        return solutionsMapper.solutionToSolutionDTO(solutionsRepository.findSolutionBySolutionID(id));
    }

    public SolutionDTO2 getSolution2ById(Long id){
        return SolutionDTO2Mapper.solutionToSolutionDTO2(solutionsRepository.findSolutionBySolutionID(id));
    }
    public List<SolutionDTO> getAllSolutions(){
        return solutionsMapper.solutionsToSolutionsDTOList(solutionsRepository.findAll());
    }
    public List<SolutionDTO> getAllSolutionsByTaskID(Long id){
        return solutionsMapper.solutionsToSolutionsDTOList(solutionsRepository.findSolutionByTask_TaskID(id));
    }

    public void updateOffer(SolutionDTO2 solutionDTO2) {
        Solution solution = SolutionDTO2Mapper.solutionDTO2ToSolution(solutionDTO2);
        solution.setTask(tasksRepository.findTaskByTaskID(solutionDTO2.getTaskID()));
        solutionsRepository.save(solution);
    }
}
