package academy.jobintech.jitechpilot.repository;

import academy.jobintech.jitechpilot.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BoardRepository extends JpaRepository<Board, Long> {
}
