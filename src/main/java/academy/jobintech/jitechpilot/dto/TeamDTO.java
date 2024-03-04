package academy.jobintech.jitechpilot.dto;


import academy.jobintech.jitechpilot.entity.Board;
import lombok.*;

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
    private List<BoardDTO> boards = new ArrayList<>();
    private List<UserResponseDto> users = new ArrayList<>();
}
