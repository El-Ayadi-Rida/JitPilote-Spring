package academy.jobintech.jitechpilot.repository;

import academy.jobintech.jitechpilot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
