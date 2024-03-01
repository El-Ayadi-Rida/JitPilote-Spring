package academy.jobintech.jitechpilot.repository;

import academy.jobintech.jitechpilot.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Yassine CHALH
 */
public interface TaskRepository extends JpaRepository<Task, Long> {

}
