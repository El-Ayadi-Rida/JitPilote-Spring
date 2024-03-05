package academy.jobintech.jitechpilot.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;
import java.util.Objects;

@ToString
@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RoleKey implements Serializable {
    @Column(name="user_id")
    Long userId;
    @Column(name="board_id")
    Long boardId;

}
