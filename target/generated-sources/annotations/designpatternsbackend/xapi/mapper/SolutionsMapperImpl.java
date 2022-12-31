package designpatternsbackend.xapi.mapper;

import designpatternsbackend.xapi.dao.Solution;
import designpatternsbackend.xapi.dto.SolutionDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-12-16T13:43:08+0100",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 17.0.4 (Amazon.com Inc.)"
)
@Component
public class SolutionsMapperImpl implements SolutionsMapper {

    @Override
    public SolutionDTO solutionToSolutionDTO(Solution solution) {
        if ( solution == null ) {
            return null;
        }

        SolutionDTO solutionDTO = new SolutionDTO();

        solutionDTO.setSolutionID( solution.getSolutionID() );
        solutionDTO.setResultsPoints( solution.getResultsPoints() );

        return solutionDTO;
    }

    @Override
    public Solution solutionDTOToSolution(SolutionDTO solutionDTO) {
        if ( solutionDTO == null ) {
            return null;
        }

        Solution solution = new Solution();

        solution.setSolutionID( solutionDTO.getSolutionID() );
        solution.setResultsPoints( solutionDTO.getResultsPoints() );

        return solution;
    }

    @Override
    public List<SolutionDTO> solutionsToSolutionsDTOList(List<Solution> solutionList) {
        if ( solutionList == null ) {
            return null;
        }

        List<SolutionDTO> list = new ArrayList<SolutionDTO>( solutionList.size() );
        for ( Solution solution : solutionList ) {
            list.add( solutionToSolutionDTO( solution ) );
        }

        return list;
    }
}
