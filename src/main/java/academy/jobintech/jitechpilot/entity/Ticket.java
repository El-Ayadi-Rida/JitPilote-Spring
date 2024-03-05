package academy.jobintech.jitechpilot.entity;

import academy.jobintech.jitechpilot.enums.TicketPriority;
import academy.jobintech.jitechpilot.enums.TicketStatus;
import jakarta.persistence.*;
import lombok.*;

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
@Entity(name = "Ticket")
@Table(name = "ticket")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ticketId;
    private String title;
    private String description;

    @Enumerated(EnumType.STRING)
    private TicketPriority priority;

    @Enumerated(EnumType.STRING)
    private TicketStatus status;

    @OneToMany(
            mappedBy = "ticket",
            orphanRemoval = true,
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<Task> tasks = new ArrayList<>();

    @ManyToOne
    @JoinColumn(
            name = "section_id_ticket",
            referencedColumnName = "sectionId",
            foreignKey = @ForeignKey(
                    name = "section_id_ticket_FK"
            )
    )
    private Section section;

    @ManyToMany(mappedBy = "tickets")
    private Set<User> users = new HashSet<>();

}
