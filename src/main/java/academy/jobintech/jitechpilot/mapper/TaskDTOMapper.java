package academy.jobintech.jitechpilot.mapper;

import academy.jobintech.jitechpilot.dto.TaskDTO;
import academy.jobintech.jitechpilot.entity.Task;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author Yassine CHALH
 */
@Component
@Scope(value = "singleton")
public class TaskDTOMapper implements EntityDTOMapper<Task, TaskDTO>{


    @Override
    public TaskDTO toDto(Task task) {

        TaskDTO dto = new TaskDTO();

        dto.setTaskId(task.getTaskId());
        dto.setTitle(task.getTitle());
        dto.setDescription(task.getDescription());
        dto.setStatus(task.getStatus());
        dto.setDeadline(task.getDeadline());
        //dto.setTicketId(task.getTicket().getTicketId());

        return dto;
    }

    @Override
    public Task toEntity(TaskDTO dto) {

        Task task = new Task();

        task.setTitle(dto.getTitle());
        task.setDescription(dto.getDescription());
        task.setStatus(dto.getStatus());
        task.setDeadline(dto.getDeadline());

        return task;
    }
}
