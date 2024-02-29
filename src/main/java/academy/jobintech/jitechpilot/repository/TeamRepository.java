package academy.jobintech.jitechpilot.repository;

import academy.jobintech.jitechpilot.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends JpaRepository<Team , Long> {
}
