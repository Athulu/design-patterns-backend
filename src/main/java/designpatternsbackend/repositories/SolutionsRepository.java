package designpatternsbackend.repositories;

import designpatternsbackend.dao.Solutions;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SolutionsRepository extends CrudRepository<Solutions, Long> {
}
