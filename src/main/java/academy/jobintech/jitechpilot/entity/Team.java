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
@Entity(name = "Team")
@Table(name = "team")
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long team_id;
    private String teamName;
    private String description;
    @OneToMany(
            mappedBy = "team",
            cascade = CascadeType.ALL
    )
    private Set<Project> projects = new HashSet<>();
}