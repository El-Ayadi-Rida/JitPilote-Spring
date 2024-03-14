package academy.jobintech.jitechpilot.controller;


import academy.jobintech.jitechpilot.dto.*;
import academy.jobintech.jitechpilot.entity.User;
import academy.jobintech.jitechpilot.enums.UserRole;
import academy.jobintech.jitechpilot.mapper.UserResponseEntityDTOMapper;
import academy.jobintech.jitechpilot.serviceImpl.UserBoardRoleServiceImpl;
import academy.jobintech.jitechpilot.serviceImpl.UserWorkspaceRoleServiceImpl;
import academy.jobintech.jitechpilot.serviceImpl.WorkspaceServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/workspaces")
@CrossOrigin(
        origins ={"*"} ,
        allowedHeaders = "*",
        methods = {RequestMethod.GET,RequestMethod.DELETE,RequestMethod.POST,RequestMethod.PUT}
)
public class WorkspaceController {

    private final UserWorkspaceRoleServiceImpl workspaceRoleService;
    private final WorkspaceServiceImpl workspaceServiceImpl;
    private final UserResponseEntityDTOMapper userResponseEntityDTOMapper ;

    @Autowired
    public WorkspaceController(UserWorkspaceRoleServiceImpl workspaceRoleService, WorkspaceServiceImpl workspaceServiceImpl, UserResponseEntityDTOMapper userResponseEntityDTOMapper) {
        this.workspaceRoleService = workspaceRoleService;
        this.workspaceServiceImpl = workspaceServiceImpl;
        this.userResponseEntityDTOMapper = userResponseEntityDTOMapper;
    }

    @GetMapping
    public List<WorkspaceDTO> getAllWorkspaces() {
        return workspaceServiceImpl.getAllWorkspaces();
    }

    @GetMapping("/{id}")
    public ResponseEntity<WorkspaceDTO> getWorkspaceById(@PathVariable(value = "id") Long workspaceId) {
        WorkspaceDTO workspaceDto = workspaceServiceImpl.getWorkspaceById(workspaceId);
        return ResponseEntity.ok().body(workspaceDto);
    }

    @PostMapping
    public WorkspaceDTO createWorkspace(@Valid @RequestBody WorkspaceDTO workspaceDto) {
        return workspaceServiceImpl.createWorkspace(workspaceDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<WorkspaceDTO> updateWorkspace(@PathVariable(value = "id") Long workspaceId,
                                                        @Valid @RequestBody WorkspaceDTO workspaceDetails) {
        WorkspaceDTO updatedWorkspaceDto = workspaceServiceImpl.updateWorkspace(workspaceId, workspaceDetails);
        return ResponseEntity.ok(updatedWorkspaceDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWorkspace(@PathVariable(value = "id") Long workspaceId) {
        workspaceRoleService.deleteUserWorkspaceRoleByWorkspaceId(workspaceId);
        workspaceServiceImpl.deleteWorkspace(workspaceId);
        return ResponseEntity.noContent().build();
    }


    @PostMapping("/{workspaceId}/addUser/{userId}")
    public ResponseEntity<String> addUserToWorkspace(@PathVariable Long workspaceId, @PathVariable Long userId) {
        UserWorkspaceRoleDto userWorkspaceRoleDto = new UserWorkspaceRoleDto(
                userId,
                workspaceId,
                UserRole.MEMBER
        );
        workspaceRoleService.assignWorkspaceRoleToUser(userWorkspaceRoleDto);
        return new ResponseEntity<>("user added successfully" , HttpStatus.OK);
    }

    @DeleteMapping("/{workspaceId}/removeUser/{userId}")
    public ResponseEntity<Void> removeUserFromWorkspace(@PathVariable Long userId) {
         workspaceRoleService.deleteUserWorkspaceRoleByUserId(userId);
        return ResponseEntity.noContent().build();

    }

    /*
    @PostMapping("/{workspaceId}/inviteUser")
    public ResponseEntity<?> inviteUserByEmail(@PathVariable Long workspaceId, @RequestParam String email) {
        boolean result = workspaceService.inviteUserByEmail(email, workspaceId);
        if (result) {
            return ResponseEntity.ok().body("Invitation sent successfully.");
        } else {
            return ResponseEntity.badRequest().body("Failed to send invitation.");
        }
    }
     */

    @PostMapping("/user/{userId}")
    public ResponseEntity<WorkspaceDTO> createWorkspaceByUser(
            @PathVariable Long userId,
            @Valid @RequestBody WorkspaceDTO workspaceDTO

    ){
        WorkspaceDTO newWorkspace = workspaceServiceImpl.createWorkspace(workspaceDTO);
        UserWorkspaceRoleDto userWorkspaceRoleDto = new UserWorkspaceRoleDto(
                userId,
                newWorkspace.getWorkspaceId(),
                UserRole.ADMIN
        );
        workspaceRoleService.assignWorkspaceRoleToUser(userWorkspaceRoleDto);
        return new ResponseEntity<>(newWorkspace , HttpStatus.CREATED);
    }



    @GetMapping("/{workspaceId}/users")
    public ResponseEntity<List<UserResponseDto>> getUsersByWorkspaceId(@PathVariable Long workspaceId) {
        List<UserResponseDto> users = workspaceRoleService.getUsersByWorkspaceId(workspaceId);
        return ResponseEntity.ok(users);
    }

}




