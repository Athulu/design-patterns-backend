package designpatternsbackend.repositories;

import designpatternsbackend.dao.Solution;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SolutionsRepository extends CrudRepository<Solution, Long> {
}
