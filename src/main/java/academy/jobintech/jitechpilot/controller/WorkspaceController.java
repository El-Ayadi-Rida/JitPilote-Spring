package academy.jobintech.jitechpilot.controller;


import academy.jobintech.jitechpilot.dto.WorkspaceDTO;
import academy.jobintech.jitechpilot.serviceImpl.WorkspaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/workspaces")
@CrossOrigin(
        origins = {"http://localhost:4200","https://jiteck-pilot.vercel.app/"},
        allowedHeaders = "*",
        methods = {RequestMethod.GET,RequestMethod.DELETE,RequestMethod.POST,RequestMethod.PUT}
)
public class WorkspaceController {

    private final WorkspaceService workspaceService;

    @Autowired
    public WorkspaceController(WorkspaceService workspaceService) {
        this.workspaceService = workspaceService;
    }

    @GetMapping
    public List<WorkspaceDTO> getAllWorkspaces() {
        return workspaceService.getAllWorkspaces();
    }

    @GetMapping("/{id}")
    public ResponseEntity<WorkspaceDTO> getWorkspaceById(@PathVariable(value = "id") Long workspaceId) {
        WorkspaceDTO workspaceDto = workspaceService.getWorkspaceById(workspaceId);
        return ResponseEntity.ok().body(workspaceDto);
    }

    @PostMapping
    public WorkspaceDTO createWorkspace(@RequestBody WorkspaceDTO workspaceDto) {
        return workspaceService.createWorkspace(workspaceDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<WorkspaceDTO> updateWorkspace(@PathVariable(value = "id") Long workspaceId,
                                                        @RequestBody WorkspaceDTO workspaceDetails) {
        WorkspaceDTO updatedWorkspaceDto = workspaceService.updateWorkspace(workspaceId, workspaceDetails);
        return ResponseEntity.ok(updatedWorkspaceDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWorkspace(@PathVariable(value = "id") Long workspaceId) {
        workspaceService.deleteWorkspace(workspaceId);
        return ResponseEntity.noContent().build();
    }
}