package academy.jobintech.jitechpilot.repository;

import academy.jobintech.jitechpilot.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<Project , Long> {
}
