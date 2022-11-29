package designpatternsbackend.mapper;

import designpatternsbackend.dao.Test;
import designpatternsbackend.dto.TestDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TestsMapper {
    List<TestDTO> testsToTestDTOList(List<Test> testList);
}
