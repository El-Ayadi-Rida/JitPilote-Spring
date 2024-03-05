package academy.jobintech.jitechpilot.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
public class UserWorkspaceRole {

    @EmbeddedId
    private RoleWorkspaceId roleWorkspaceId;


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
    @MapsId("workspaceId")
    @JoinColumn(
            name="workspace_id",
            foreignKey = @ForeignKey(
                    name = "role_workspace_id_fk"
            )
    )
    private Workspace workspace;
}
