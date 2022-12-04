package designpatternsbackend.xapi.mapper;

import designpatternsbackend.xapi.dao.Solution;
import designpatternsbackend.xapi.dto.SolutionDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SolutionsMapper {
    SolutionDTO solutionToSolutionDTO(Solution solution);
    Solution solutionDTOToSolution(SolutionDTO solutionDTO);
    List<SolutionDTO> solutionsToSolutionsDTOList(List<Solution> solutionList);
}
