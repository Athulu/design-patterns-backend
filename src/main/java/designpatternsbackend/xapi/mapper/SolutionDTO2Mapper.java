package designpatternsbackend.xapi.mapper;

import designpatternsbackend.xapi.dao.Solution;
import designpatternsbackend.xapi.dao.Task;
import designpatternsbackend.xapi.dto.SolutionDTO;
import designpatternsbackend.xapi.dto.SolutionDTO2;

public class SolutionDTO2Mapper {
    public static SolutionDTO2 solutionToSolutionDTO2(Solution solution) {
        if ( solution == null ) {
            return null;
        }
        SolutionDTO2 solutionDTO2 = new SolutionDTO2();
        solutionDTO2.setSolutionID( solution.getSolutionID() );
        solutionDTO2.setResultsPoints( solution.getResultsPoints() );
        solutionDTO2.setTaskID( solution.getTask().getTaskID() );

        return solutionDTO2;
    }

    public static Solution solutionDTO2ToSolution(SolutionDTO2 solutionDTO2) {
        if ( solutionDTO2 == null ) {
            return null;
        }

        Solution solution = new Solution();

        solution.setSolutionID( solutionDTO2.getSolutionID() );
        solution.setResultsPoints( solutionDTO2.getResultsPoints() );

        return solution;
    }

}
