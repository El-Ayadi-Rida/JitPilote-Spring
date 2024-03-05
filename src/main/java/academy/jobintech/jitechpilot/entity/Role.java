package academy.jobintech.jitechpilot.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Role {
    @EmbeddedId
    private RoleKey roleId;

    @ManyToOne
    @MapsId("userId")
    @JoinColumn(
            name="user_id",
            foreignKey = @ForeignKey(
                    name = "role_user_id_fk"
            )
    )
    private User user;

    @ManyToOne
    @MapsId("boardId")
    @JoinColumn(
            name="board_id",
            foreignKey = @ForeignKey(
                    name = "role_board_id_fk"
            )
    )
    private Board board;

    private String user_role;

}
