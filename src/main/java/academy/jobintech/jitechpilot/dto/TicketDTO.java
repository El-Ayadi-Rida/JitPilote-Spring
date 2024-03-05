package academy.jobintech.jitechpilot.dto;

import academy.jobintech.jitechpilot.entity.Task;
import academy.jobintech.jitechpilot.entity.User;
import academy.jobintech.jitechpilot.enums.TicketPriority;
import academy.jobintech.jitechpilot.enums.TicketStatus;
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
    private String title;
    private String description;
    private TicketPriority priority;
    private TicketStatus status;
    private Long projectId;
    private Long assignedToUserId;
    private List<TaskDTO> tasks = new ArrayList<>();
    private List<UserResponseDto> users = new ArrayList<>();

}
