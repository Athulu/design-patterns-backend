package designpatternsbackend.xapi.mapper;

import designpatternsbackend.xapi.dao.Solution;
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

}
