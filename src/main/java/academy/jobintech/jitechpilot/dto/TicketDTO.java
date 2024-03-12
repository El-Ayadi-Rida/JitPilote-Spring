package academy.jobintech.jitechpilot.dto;

import academy.jobintech.jitechpilot.entity.Task;
import academy.jobintech.jitechpilot.entity.User;
import academy.jobintech.jitechpilot.enums.TicketPriority;
import academy.jobintech.jitechpilot.enums.TicketStatus;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Yassine CHALH
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TicketDTO {

    private Long ticketId;

    @NotEmpty(message = "ticket title should not be empty")
    @Size(min = 2, max = 20, message = "title should have be min 2 and max 20")
    private String title;

    @NotEmpty(message = "description should not be empty")
    @Size(min = 2, max = 50, message = "title should have be min 2 and max 50")
    private String description;

    private TicketPriority priority;
    private TicketStatus status;
    private List<TaskDTO> tasks = new ArrayList<>();
    private List<UserResponseDto> users = new ArrayList<>();

}
