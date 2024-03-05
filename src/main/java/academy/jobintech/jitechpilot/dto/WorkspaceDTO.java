package academy.jobintech.jitechpilot.dto;


import academy.jobintech.jitechpilot.entity.Board;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class WorkspaceDTO {

    private Long workspaceId;
    private String name;
    private String description;
    private List<Board> boards = new ArrayList<>();


}
