package designpatternsbackend.xapi.repositories;

import designpatternsbackend.xapi.dao.Result;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResultsRepository extends PagingAndSortingRepository<Result, Long> {
//public interface ResultsRepository extends CrudRepository<Result, Long> {
    Result findResultsByResultID(Long id);

    List<Result> findAll();

    List<Result> findResultsBySolution_SolutionID(Long id);

    List<Result> findResultsByTest_TestID(Long id);
}
