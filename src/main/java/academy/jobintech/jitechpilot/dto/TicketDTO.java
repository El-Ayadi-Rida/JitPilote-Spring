package academy.jobintech.jitechpilot.dto;

import academy.jobintech.jitechpilot.enums.TicketPriority;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private TicketPriority priority;
    private List<TaskDTO> tasks = new ArrayList<>();
    private List<UserResponseDto> users = new ArrayList<>();

}
