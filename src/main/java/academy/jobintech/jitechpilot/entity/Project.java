package academy.jobintech.jitechpilot.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.security.PublicKey;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity(name = "Project")
@Table(name = "project")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long project_id;
    private String projectName;
    private String description;
    private LocalDateTime start_date;
    private LocalDateTime end_date;
    private String status;
    @ManyToOne
    @JoinColumn(
            name = "team_id_project",
            referencedColumnName = "team_id",
            foreignKey = @ForeignKey(
                name = "team_id_project_FK"
            )
    )
    private Team team;
    @PrePersist
    public void initStartDate(){
        start_date = LocalDateTime.now();
    }
}
