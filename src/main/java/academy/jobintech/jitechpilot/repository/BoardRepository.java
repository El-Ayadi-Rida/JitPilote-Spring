package academy.jobintech.jitechpilot.repository;

import academy.jobintech.jitechpilot.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface BoardRepository extends JpaRepository<Board, Long> {
    List<Board> findByworkspaceWorkspaceId(Long workspaceId);
}
