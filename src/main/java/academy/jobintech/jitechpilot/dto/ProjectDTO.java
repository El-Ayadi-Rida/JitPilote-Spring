package academy.jobintech.jitechpilot.dto;

import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ProjectDTO {
    private Long projectId;
    private String projectName;
    private String description;
    private LocalDateTime start_date;
    private LocalDateTime end_date;
    private String status;

}
