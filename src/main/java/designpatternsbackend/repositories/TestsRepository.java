package designpatternsbackend.repositories;

import designpatternsbackend.dao.Test;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestsRepository extends CrudRepository<Test, Long> {
}
