package academy.jobintech.jitechpilot.entity;


import jakarta.persistence.*;
import lombok.ToString;

@ToString
@Entity
public class Role {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // or other appropriate strategy
    @EmbeddedId
    private RoleKey id;

    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name="user_id")
    private User user;

    @ManyToOne
    @MapsId("boardId")
    @JoinColumn(name="board_id")
    private Board board;

    private String user_role;

    public Role(RoleKey id, User user, Board board, String user_role) {
        this.id = id;
        this.user = user;
        this.board = board;
        this.user_role = user_role;
    }

    public Role() {
    }

    public RoleKey getId() {
        return id;
    }

    public void setId(RoleKey id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public String getUser_role() {
        return user_role;
    }

    public void setUser_role(String user_role) {
        this.user_role = user_role;
    }
}
