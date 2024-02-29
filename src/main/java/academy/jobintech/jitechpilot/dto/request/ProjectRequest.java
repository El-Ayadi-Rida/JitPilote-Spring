package academy.jobintech.jitechpilot.dto.request;

import java.time.LocalDateTime;

public class ProjectRequest {
    private String projectName;
    private String description;
    private LocalDateTime start_date;
    private LocalDateTime end_date;
    private String status;
    private Long teamId;
}
