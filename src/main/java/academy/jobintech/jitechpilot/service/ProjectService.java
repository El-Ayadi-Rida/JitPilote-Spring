package academy.jobintech.jitechpilot.service;

import academy.jobintech.jitechpilot.dto.ResponseProjectPage;
import academy.jobintech.jitechpilot.dto.ProjectDTO;
import academy.jobintech.jitechpilot.entity.Project;

public interface ProjectService {
    ProjectDTO createProject(ProjectDTO projectDTO);
    ProjectDTO getProjectById(Long projectId);
    Project getProjectByIdHelper(Long projectId);
    ResponseProjectPage getAllProjects(int pageNo , int pageSize , String sortBy , String sortDir);
    ProjectDTO updateProject(Long projectId, ProjectDTO projectDTO);
    void deleteProject(Long projectId);
}
