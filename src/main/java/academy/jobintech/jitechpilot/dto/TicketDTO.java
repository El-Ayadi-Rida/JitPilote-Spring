package academy.jobintech.jitechpilot.dto;

import academy.jobintech.jitechpilot.enums.TicketPriority;
import academy.jobintech.jitechpilot.enums.TicketStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
}
