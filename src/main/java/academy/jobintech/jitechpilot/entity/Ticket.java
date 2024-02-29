package academy.jobintech.jitechpilot.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ticketId;
    private String title;
    private String description;
    private String priority;
    private String status;
    @OneToMany(
            mappedBy = "ticket",
            orphanRemoval = true,
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private Set<Task> tasks = new HashSet<>();
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
