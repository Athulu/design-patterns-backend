package designpatternsbackend.mapper;

import designpatternsbackend.dao.Solution;
import designpatternsbackend.dto.SolutionDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SolutionsMapper {
    List<SolutionDTO> solutionsToSolutionsDTOList(List<Solution> solutionList);
}
