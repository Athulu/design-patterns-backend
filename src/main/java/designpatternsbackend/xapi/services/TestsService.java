package designpatternsbackend.xapi.services;

import designpatternsbackend.xapi.repositories.TestsRepository;
import designpatternsbackend.xapi.dto.TestDTO;
import designpatternsbackend.xapi.mapper.TestsMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TestsService {
    private final TestsRepository testsRepository;
    private final TestsMapper testsMapper;

    public List<TestDTO> getAllTests(){
        return testsMapper.testsToTestDTOList(testsRepository.findAll());
    }

    public List<TestDTO> getAllTestsByTaskID(Long id){
        return testsMapper.testsToTestDTOList(testsRepository.findTestByTask_TaskID(id));
    }
}
