package academy.jobintech.jitechpilot.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(name="firstName")
    private String firstName;

    @Column(name="lastName")
    private String lastName;

    @Column(name="userName")
    private String userName;

    @Column(name="email")
    private String email;
    @Column(name="password")
    private String password;
    @Column(name="role")
    private String role;
    @ManyToOne
    @JoinColumn(
            name = "team_id_user",
            referencedColumnName = "teamId",
            foreignKey = @ForeignKey(
                    name = "user_id_team_FK"
            )
    )
    private Team team;
    @OneToMany(
            mappedBy = "user",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private Set<Ticket> tickets = new HashSet<>();
    @Column(name = "createdAt", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }
}
