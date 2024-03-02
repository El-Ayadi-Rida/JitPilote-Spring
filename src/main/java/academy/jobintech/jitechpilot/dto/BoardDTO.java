package academy.jobintech.jitechpilot.dto;

import academy.jobintech.jitechpilot.enums.BoardStatus;
import lombok.*;

import java.time.LocalDateTime;

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
    private BoardStatus status;

}
