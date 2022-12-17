package designpatternsbackend.xapi.mapper;

import designpatternsbackend.xapi.dao.Result;
import designpatternsbackend.xapi.dto.ResultDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-12-16T13:43:07+0100",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 17.0.4 (Amazon.com Inc.)"
)
@Component
public class ResultsMapperImpl implements ResultsMapper {

    @Override
    public ResultDTO resultToResultDTO(Result result) {
        if ( result == null ) {
            return null;
        }

        ResultDTO resultDTO = new ResultDTO();

        resultDTO.setResultID( result.getResultID() );
        resultDTO.setIsCorrect( result.getIsCorrect() );
        resultDTO.setOutputData( result.getOutputData() );
        resultDTO.setCookie( result.getCookie() );

        return resultDTO;
    }

    @Override
    public List<ResultDTO> resultsToResultDTOList(List<Result> resultsList) {
        if ( resultsList == null ) {
            return null;
        }

        List<ResultDTO> list = new ArrayList<ResultDTO>( resultsList.size() );
        for ( Result result : resultsList ) {
            list.add( resultToResultDTO( result ) );
        }

        return list;
    }
}
