package academy.jobintech.jitechpilot.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@ToString
@EqualsAndHashCode
@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RoleWorkspaceId implements Serializable {

    private Long userId;

    private Long workspaceId;

}
