package academy.jobintech.jitechpilot.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Setter
@Getter
@Entity(name = "User")
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
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

//    @ManyToOne
//    @JoinColumn(
//            name = "team_id_user",
//            referencedColumnName = "teamId",
//            foreignKey = @ForeignKey(
//                    name = "team_id_user_FK"
//            )
//    )
//    private Team team;


    @OneToMany(mappedBy = "user")
    List<Role> roles = new ArrayList<>();


    @ManyToMany
    @JoinTable(
            name = "members",
            joinColumns = @JoinColumn(name = "userId"),
            inverseJoinColumns = @JoinColumn(name = "ticketId"))
    private List<Ticket> tickets = new ArrayList<>();


    @Column(name = "createdAt", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }
}
