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
            name = "project_id_ticket",
            referencedColumnName = "projectId",
            foreignKey = @ForeignKey(
                    name = "project_id_ticket_FK"
            )
    )
    private Project project;

    @ManyToOne
    @JoinColumn(
            name = "user_id_ticket",
            referencedColumnName = "userId",
            foreignKey = @ForeignKey(
                    name = "user_id_ticket_FK"
            )
    )
    private User user;

}
