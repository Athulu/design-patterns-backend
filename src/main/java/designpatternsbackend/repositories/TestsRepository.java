package designpatternsbackend.repositories;

import designpatternsbackend.dao.Test;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TestsRepository extends PagingAndSortingRepository<Test, Long> {
    List<Test> findAll();

    List<Test> findTestByTask_TaskID(Long id);
}
