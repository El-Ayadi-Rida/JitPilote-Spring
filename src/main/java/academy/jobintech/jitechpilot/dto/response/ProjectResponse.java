package academy.jobintech.jitechpilot.dto.response;

import java.time.LocalDateTime;

public class ProjectResponse {
    private Long project_id;
    private String projectName;
    private String description;
    private LocalDateTime start_date;
    private LocalDateTime end_date;
    private String status;
    private Long teamId;
}
