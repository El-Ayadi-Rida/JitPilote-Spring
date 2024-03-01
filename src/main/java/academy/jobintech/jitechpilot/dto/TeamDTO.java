package academy.jobintech.jitechpilot.dto;


import academy.jobintech.jitechpilot.entity.Project;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class TeamDTO {
    private Long teamId;
    private String teamName;
    private String description;
    private List<Project> projects = new ArrayList<>();
}
