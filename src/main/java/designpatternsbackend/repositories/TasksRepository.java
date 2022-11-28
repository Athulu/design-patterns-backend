package designpatternsbackend.repositories;

import designpatternsbackend.dao.Task;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TasksRepository extends CrudRepository<Task, Long> {
}
