package academy.jobintech.jitechpilot.service;

import academy.jobintech.jitechpilot.dto.UserBoardRoleDTO;
import academy.jobintech.jitechpilot.dto.UserWorkspaceRoleDto;
import academy.jobintech.jitechpilot.entity.UserWorkspaceRole;

public interface UserWorkspaceRoleService {

    UserWorkspaceRoleDto assignWorkspaceRoleToUser(UserWorkspaceRoleDto userWorkspaceRoleDto);
    void deleteUserWorkspaceRoleByWorkspaceId(Long workspaceId);
}
