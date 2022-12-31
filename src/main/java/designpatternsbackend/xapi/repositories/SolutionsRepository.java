package designpatternsbackend.xapi.repositories;

import designpatternsbackend.xapi.dao.Solution;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SolutionsRepository extends PagingAndSortingRepository<Solution, Long> {
    Solution findSolutionBySolutionID(Long id);
    List<Solution> findAll();
    List<Solution> findSolutionByTask_TaskID(Long id);

}
