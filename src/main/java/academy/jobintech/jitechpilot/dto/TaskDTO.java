package academy.jobintech.jitechpilot.dto;

import academy.jobintech.jitechpilot.enums.TaskStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * @author Yassine CHALH
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TaskDTO {
    private Long taskId;
    private String title;
    private String description;
    private TaskStatus status;
    private LocalDateTime deadline;
    private Long ticketId;
}
