package designpatternsbackend.services;

import designpatternsbackend.dto.TaskDTO;
import designpatternsbackend.mapper.TasksMapper;
import designpatternsbackend.repositories.TasksRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TasksService {
    private final TasksRepository tasksRepository;
    private final TasksMapper tasksMapper;
    public List<TaskDTO> getAllTasks(){
        return tasksMapper.tasksToTaskDTOList(tasksRepository.findAll());
    }
}
