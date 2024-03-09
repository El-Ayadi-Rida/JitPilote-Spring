package academy.jobintech.jitechpilot.dto;

import academy.jobintech.jitechpilot.enums.TaskStatus;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
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


    @NotEmpty(message = "task title should not be empty")
    @Size(min = 2, max = 20, message = "title should have be min 2 and max 20")
    private String title;

    @NotEmpty(message = "description should not be empty")
    @Size(min = 2, max = 50, message = "description should have be min 2 and max 50")
    private String description;

    private TaskStatus status;
    private LocalDateTime deadline;
    private Long ticketId;
}
