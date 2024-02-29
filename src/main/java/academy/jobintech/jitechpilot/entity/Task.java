package academy.jobintech.jitechpilot.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long taskId;
    private String title;
    private String description;
    private String status;
    private LocalDateTime deadline;
    @ManyToOne
    @JoinColumn(
            name = "ticket_id_task",
            referencedColumnName = "taskId",
            foreignKey = @ForeignKey(
                    name = "ticket_id_task_FK"
            )
    )
    private Ticket ticket;
}
