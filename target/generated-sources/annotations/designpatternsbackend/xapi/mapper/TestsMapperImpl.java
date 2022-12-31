package designpatternsbackend.xapi.mapper;

import designpatternsbackend.xapi.dao.Test;
import designpatternsbackend.xapi.dto.TestDTO;
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
public class TestsMapperImpl implements TestsMapper {

    @Override
    public List<TestDTO> testsToTestDTOList(List<Test> testList) {
        if ( testList == null ) {
            return null;
        }

        List<TestDTO> list = new ArrayList<TestDTO>( testList.size() );
        for ( Test test : testList ) {
            list.add( testToTestDTO( test ) );
        }

        return list;
    }

    protected TestDTO testToTestDTO(Test test) {
        if ( test == null ) {
            return null;
        }

        TestDTO testDTO = new TestDTO();

        testDTO.setTestID( test.getTestID() );
        testDTO.setInputData( test.getInputData() );
        testDTO.setOutputData( test.getOutputData() );

        return testDTO;
    }
}
