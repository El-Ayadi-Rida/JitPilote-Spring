package academy.jobintech.jitechpilot.entity;

import academy.jobintech.jitechpilot.enums.TaskStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Setter
@Getter
@Entity(name = "Task")
@Table(name = "task")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long taskId;
    private String title;
    private String description;

    @Enumerated(EnumType.STRING)
    private TaskStatus status;

    private LocalDateTime deadline;

    @ManyToOne
    @JoinColumn(
            name = "ticket_id_task",
            referencedColumnName = "ticketId",
            foreignKey = @ForeignKey(
                    name = "ticket_id_task_FK"
            )
    )
    private Ticket ticket;
}
