package academy.jobintech.jitechpilot.controller;


import academy.jobintech.jitechpilot.dto.UserResponseDto;
import academy.jobintech.jitechpilot.dto.WorkspaceDTO;
import academy.jobintech.jitechpilot.mapper.UserResponseEntityDTOMapper;
import academy.jobintech.jitechpilot.serviceImpl.WorkspaceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/workspaces")
@CrossOrigin(
        origins ={"http://localhost:4200","https://jiteck-pilot.vercel.app/"} ,
        allowedHeaders = "*",
        methods = {RequestMethod.GET,RequestMethod.DELETE,RequestMethod.POST,RequestMethod.PUT}
)
public class WorkspaceController {

    private final WorkspaceServiceImpl workspaceServiceImpl;
    private final UserResponseEntityDTOMapper userResponseEntityDTOMapper ;

    @Autowired
    public WorkspaceController(WorkspaceServiceImpl workspaceServiceImpl, UserResponseEntityDTOMapper userResponseEntityDTOMapper) {
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
    public WorkspaceDTO createWorkspace(@RequestBody WorkspaceDTO workspaceDto) {
        return workspaceServiceImpl.createWorkspace(workspaceDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<WorkspaceDTO> updateWorkspace(@PathVariable(value = "id") Long workspaceId,
                                                        @RequestBody WorkspaceDTO workspaceDetails) {
        WorkspaceDTO updatedWorkspaceDto = workspaceServiceImpl.updateWorkspace(workspaceId, workspaceDetails);
        return ResponseEntity.ok(updatedWorkspaceDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWorkspace(@PathVariable(value = "id") Long workspaceId) {
        workspaceServiceImpl.deleteWorkspace(workspaceId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{workspaceId}/users")
    public ResponseEntity<List<UserResponseDto>> getUsersByWorkspace(@PathVariable Long workspaceId) {
        List<UserResponseDto> users = userResponseEntityDTOMapper.toDtos(workspaceServiceImpl.getUsersByWorkspace(workspaceId));
        if(users.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(users);
    }

    @PostMapping("/{workspaceId}/addUser/{userId}")
    public ResponseEntity<?> addUserToWorkspace(@PathVariable Long workspaceId, @PathVariable Long userId) {
        boolean result = workspaceServiceImpl.addUserToWorkspace(userId, workspaceId);
        if (result) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.badRequest().body("Failed to add user to workspace.");
        }
    }

    @DeleteMapping("/{workspaceId}/removeUser/{userId}")
    public ResponseEntity<?> removeUserFromWorkspace(@PathVariable Long workspaceId, @PathVariable Long userId) {
        boolean result = workspaceServiceImpl.removeUserFromWorkspace(userId, workspaceId);
        if (result) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
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

}




