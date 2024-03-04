package academy.jobintech.jitechpilot.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@EqualsAndHashCode
@Entity(name = "Section")
@Table(name = "section")
public class Section {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sectionId;
    private String sectionTitle;
    private String description;

    @ManyToOne
    @JoinColumn(
            name = "board_id_section",
            referencedColumnName = "boardId",
            foreignKey = @ForeignKey(
                    name = "board_id_section_FK"
            )
    )
    private Board board;

    @OneToMany(
            mappedBy = "section",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    private List<Ticket> tickets = new ArrayList<>();


}