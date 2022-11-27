package designpatternsbackend.repositories;

import designpatternsbackend.dao.Tests;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestsRepository extends CrudRepository<Tests, Long> {
}
