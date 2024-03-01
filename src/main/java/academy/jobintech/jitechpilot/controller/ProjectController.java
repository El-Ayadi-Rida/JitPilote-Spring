package academy.jobintech.jitechpilot.controller;

import academy.jobintech.jitechpilot.dto.ProjectDTO;
import academy.jobintech.jitechpilot.dto.ResponseProjectPage;
import academy.jobintech.jitechpilot.serviceImpl.ProjectServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/projects")
public class ProjectController {
    @Autowired
    private ProjectServiceImpl projectService;

    @PostMapping("/create")
    public ResponseEntity<ProjectDTO> createProject(
            @RequestBody ProjectDTO projectDTO
    ){
        ProjectDTO newProject = projectService.createProject(projectDTO);
        return new ResponseEntity<>(newProject , HttpStatus.CREATED);
    }

    @GetMapping("/{project_id}")
    public ResponseEntity<ProjectDTO> getProjectById(@PathVariable("project_id") Long project_id){
        ProjectDTO projectDTOResponse = projectService.getProjectById(project_id);
        return new ResponseEntity<>(projectDTOResponse , HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<ResponseProjectPage>  getAllProjects(
            @RequestParam(name = "pageNo" ,defaultValue = "0" ,required = false) int pageNo,
            @RequestParam(name = "pageSize" ,defaultValue = "5" ,required = false) int pageSize,
            @RequestParam(name = "sortBy" ,defaultValue = "projectId" ,required = false) String sortBy,
            @RequestParam(name = "sortDir" ,defaultValue = "asc" ,required = false) String sortDir
    ){
        return ResponseEntity.ok(projectService.getAllProjects(pageNo, pageSize , sortBy , sortDir));
    }

    @PutMapping("/update/{project_id}")
    public ResponseEntity<ProjectDTO> updateProject(
            @RequestBody ProjectDTO projectDTO,
            @PathVariable("project_id") Long project_id){
        ProjectDTO updatedProject = projectService.updateProject(project_id , projectDTO);
        return new ResponseEntity<>(updatedProject , HttpStatus.OK);
    }

    @DeleteMapping("/delete/{project_id}")
    public ResponseEntity<String> deleteProject(@PathVariable("project_id") Long project_id){
        projectService.deleteProject(project_id);
        return ResponseEntity.ok("Project with Id: "+project_id+" deleted successfully");
    }
}
