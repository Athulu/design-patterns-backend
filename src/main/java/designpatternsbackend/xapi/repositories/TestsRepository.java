package designpatternsbackend.xapi.repositories;

import designpatternsbackend.xapi.dao.Test;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TestsRepository extends PagingAndSortingRepository<Test, Long> {
    List<Test> findAll();

    List<Test> findTestByTask_TaskID(Long id);
}
