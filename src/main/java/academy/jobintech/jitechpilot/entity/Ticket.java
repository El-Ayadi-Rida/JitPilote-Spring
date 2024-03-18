package academy.jobintech.jitechpilot.entity;

import academy.jobintech.jitechpilot.enums.TicketPriority;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@EqualsAndHashCode
@Entity(name = "Ticket")
@Table(name = "ticket")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ticketId;

    private String title;

    private String description;
    private String descriptionContent;

    @Column(name = "startDate", nullable = false, updatable = false)
    private LocalDateTime startDate;
    @PrePersist
    protected void onCreate() {
        startDate = LocalDateTime.now();
    }

    private LocalDateTime endDate;

    @Enumerated(EnumType.STRING)
    private TicketPriority priority;


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
    private List<User> users = new ArrayList<>();

    @Transient
    private double progress;

    @PostLoad
    @PostUpdate
    public void calculateProgress() {
        if (tasks.isEmpty()) {
            progress = 0;
            return;
        }
        long completedTasksCount = tasks.stream().filter(Task::isDone).count();

        // Calculate the progress percentage
        progress = (double) completedTasksCount / tasks.size() * 100.0;
    }
}
