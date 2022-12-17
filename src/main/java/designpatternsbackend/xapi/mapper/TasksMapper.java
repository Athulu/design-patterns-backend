package designpatternsbackend.xapi.mapper;

import designpatternsbackend.xapi.dao.Task;
import designpatternsbackend.xapi.dto.TaskDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TasksMapper {
    List<TaskDTO> tasksToTaskDTOList(List<Task> taskList);
}
