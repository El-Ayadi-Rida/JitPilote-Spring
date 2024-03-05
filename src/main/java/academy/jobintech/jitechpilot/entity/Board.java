package academy.jobintech.jitechpilot.entity;

import academy.jobintech.jitechpilot.enums.BoardStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@EqualsAndHashCode
@Entity(name = "Board")
@Table(name = "board")
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long boardId;
    private String boardName;
    private String description;
    private LocalDateTime start_date;

    @Enumerated(EnumType.STRING)
    private BoardStatus status;

    @OneToMany(mappedBy = "board")
    List<UserBoardRole> userBoardRoles = new ArrayList<>();

    @OneToMany(
            mappedBy = "board",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    private List<Section> sections = new ArrayList<>();

    @ManyToOne
    @JoinColumn(
            name="workspace_id_board",
            referencedColumnName = "workspaceId",
            foreignKey = @ForeignKey(
                    name = "workspace_id_board_FK"
            )
    )
    private Workspace workspace;


    @PrePersist
    public void initStartDate(){
        start_date = LocalDateTime.now();
    }

    //    @ManyToOne
//    @JoinColumn(
//            name = "team_id_board",
//            referencedColumnName = "teamId",
//            foreignKey = @ForeignKey(
//                name = "team_id_board_FK"
//            )
//    )
//    private Team team;


}
