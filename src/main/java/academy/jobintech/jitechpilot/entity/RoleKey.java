package academy.jobintech.jitechpilot.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.ToString;

import java.io.Serializable;
import java.util.Objects;

@ToString
@Embeddable
public class RoleKey implements Serializable {


    @Column(name="user_id")
    Long userId;

    @Column(name="board_id")
    Long boardId;

    public RoleKey(Long userId, Long boardId) {
        this.userId = userId;
        this.boardId = boardId;
    }

    public RoleKey() {

    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getBoardId() {
        return boardId;
    }

    public void setBoardId(Long boardId) {
        this.boardId = boardId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoleKey roleKey = (RoleKey) o;
        return Objects.equals(userId, roleKey.userId) && Objects.equals(boardId, roleKey.boardId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, boardId);
    }
}
