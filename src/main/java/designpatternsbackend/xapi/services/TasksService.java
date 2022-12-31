package designpatternsbackend.xapi.services;

import designpatternsbackend.xapi.mapper.TasksMapper;
import designpatternsbackend.xapi.repositories.TasksRepository;
import designpatternsbackend.xapi.dto.TaskDTO;
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
