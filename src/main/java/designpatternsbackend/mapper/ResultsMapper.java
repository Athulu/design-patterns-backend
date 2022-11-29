package designpatternsbackend.mapper;

import designpatternsbackend.dao.Result;
import designpatternsbackend.dto.ResultDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ResultsMapper {
    ResultDTO resultToResultDTO(Result result);
    List<ResultDTO> resultsToResultDTOList(List<Result> resultsList);
}
