package designpatternsbackend.repositories;

import designpatternsbackend.dao.Solution;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SolutionsRepository extends PagingAndSortingRepository<Solution, Long> {
    List<Solution> findAll();

    List<Solution> findSolutionByTask_TaskID(Long id);
}
