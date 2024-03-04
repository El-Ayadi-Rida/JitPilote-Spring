package academy.jobintech.jitechpilot.repository;

import academy.jobintech.jitechpilot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findUserByEmail(String email);

    List<User> findByteamTeamId(Long teamId);
}
