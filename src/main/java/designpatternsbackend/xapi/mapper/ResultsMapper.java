package designpatternsbackend.xapi.mapper;

import designpatternsbackend.xapi.dao.Result;
import designpatternsbackend.xapi.dto.ResultDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ResultsMapper {
    ResultDTO resultToResultDTO(Result result);
    List<ResultDTO> resultsToResultDTOList(List<Result> resultsList);
}
