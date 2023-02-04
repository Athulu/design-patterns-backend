package designpatternsbackend.xapi.mapper;

import designpatternsbackend.xapi.dao.Task;
import designpatternsbackend.xapi.dto.TaskDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-02-04T06:19:06+0100",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 17.0.4 (Amazon.com Inc.)"
)
@Component
public class TasksMapperImpl implements TasksMapper {

    @Override
    public List<TaskDTO> tasksToTaskDTOList(List<Task> taskList) {
        if ( taskList == null ) {
            return null;
        }

        List<TaskDTO> list = new ArrayList<TaskDTO>( taskList.size() );
        for ( Task task : taskList ) {
            list.add( taskToTaskDTO( task ) );
        }

        return list;
    }

    protected TaskDTO taskToTaskDTO(Task task) {
        if ( task == null ) {
            return null;
        }

        TaskDTO taskDTO = new TaskDTO();

        taskDTO.setTaskID( task.getTaskID() );
        taskDTO.setName( task.getName() );
        taskDTO.setDesignPattern( task.getDesignPattern() );
        taskDTO.setDescription( task.getDescription() );

        return taskDTO;
    }
}
