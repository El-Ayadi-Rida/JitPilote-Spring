package academy.jobintech.jitechpilot.repository;


import academy.jobintech.jitechpilot.entity.RoleWorkspaceId;
import academy.jobintech.jitechpilot.entity.UserWorkspaceRole;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserWorkspaceRoleRepository extends JpaRepository<UserWorkspaceRole, Long> {
    @Modifying
    @Transactional
    @Query("DELETE FROM UserWorkspaceRole uwr WHERE uwr.user.userId = :userId AND uwr.workspace.workspaceId = :workspaceId")
    void deleteByUserIdAndWorkspaceId(@Param("userId") Long userId, @Param("workspaceId") Long workspaceId);
}
