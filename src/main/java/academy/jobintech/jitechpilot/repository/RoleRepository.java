package academy.jobintech.jitechpilot.repository;

import academy.jobintech.jitechpilot.entity.Role;
import academy.jobintech.jitechpilot.entity.RoleKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, RoleKey> {
}
