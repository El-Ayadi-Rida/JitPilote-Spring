package academy.jobintech.jitechpilot.service;

import academy.jobintech.jitechpilot.dto.pagination.PaginationResponseProject;
import academy.jobintech.jitechpilot.dto.request.ProjectRequest;
import academy.jobintech.jitechpilot.dto.response.ProjectResponse;

public interface ProjectService {
    ProjectResponse createProject(ProjectRequest projectRequest);
    ProjectResponse getProjectById(Long projectId);
    PaginationResponseProject getAllProjects(int pageNo , int pageSize , String sortBy , String sortDir);
    ProjectResponse updateProject(Long projectId, ProjectRequest projectRequest);
    void deleteProject(Long projectId);
}
