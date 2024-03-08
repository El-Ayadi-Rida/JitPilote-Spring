package academy.jobintech.jitechpilot.dto;

import academy.jobintech.jitechpilot.entity.Section;
import academy.jobintech.jitechpilot.enums.AccessLevel;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class BoardDTO {
    private Long boardId;
    private String boardName;
    private String description;
    private LocalDateTime start_date;
    private boolean fav;
    private AccessLevel accessLevel;
    private List<SectionDTO> sections = new ArrayList<>();


}
