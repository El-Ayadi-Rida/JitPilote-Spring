package academy.jobintech.jitechpilot.entity;

import academy.jobintech.jitechpilot.enums.BoardStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    @ManyToOne
    @JoinColumn(
            name = "team_id_board",
            referencedColumnName = "teamId",
            foreignKey = @ForeignKey(
                name = "team_id_board_FK"
            )
    )
    private Team team;


    @OneToMany(
            mappedBy = "board",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    private List<Section> sections = new ArrayList<>();

    @PrePersist
    public void initStartDate(){
        start_date = LocalDateTime.now();
    }
}
