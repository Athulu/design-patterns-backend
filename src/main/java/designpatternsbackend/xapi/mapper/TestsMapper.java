package designpatternsbackend.xapi.mapper;

import designpatternsbackend.xapi.dao.Test;
import designpatternsbackend.xapi.dto.TestDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TestsMapper {
    List<TestDTO> testsToTestDTOList(List<Test> testList);
}
