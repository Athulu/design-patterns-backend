package designpatternsbackend.services;

import designpatternsbackend.repositories.TasksRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TasksService {
    private final TasksRepository tasksRepository;
}
