package designpatternsbackend.xapi.repositories;

import designpatternsbackend.xapi.dao.Task;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TasksRepository extends CrudRepository<Task, Long> {
    List<Task> findAll();
}
