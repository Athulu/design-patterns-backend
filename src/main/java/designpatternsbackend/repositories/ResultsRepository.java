package designpatternsbackend.repositories;

import designpatternsbackend.dao.Results;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResultsRepository extends CrudRepository<Results, Long> {
}
