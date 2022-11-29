package designpatternsbackend.xapi.mapper;

import designpatternsbackend.xapi.dao.Result;
import designpatternsbackend.xapi.dto.ResultDTO;
import designpatternsbackend.xapi.dto.ResultDTO2;

import java.util.ArrayList;
import java.util.List;

public class ResultDTO2Mapper {
    public static ResultDTO2 resultToResultDTO(Result result) {
        if ( result == null ) {
            return null;
        }

        ResultDTO2 resultDTO2 = new ResultDTO2();

        resultDTO2.setIsCorrect( result.getIsCorrect() );
        resultDTO2.setOutputData( result.getOutputData() );
        resultDTO2.setTestID( result.getTest().getTestID() );

        return resultDTO2;
    }

    public static List<ResultDTO2> resultsToResultDTO2List(List<Result> resultsList) {
        if ( resultsList == null ) {
            return null;
        }

        List<ResultDTO2> list = new ArrayList<>( resultsList.size() );
        for ( Result result : resultsList ) {
            list.add( resultToResultDTO( result ) );
        }

        return list;
    }
}
