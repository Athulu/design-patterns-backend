package designpatternsbackend.mapper;

import designpatternsbackend.dao.Task;
import designpatternsbackend.dto.TaskDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TasksMapper {
    List<TaskDTO> tasksToTaskDTOList(List<Task> taskList);
}
