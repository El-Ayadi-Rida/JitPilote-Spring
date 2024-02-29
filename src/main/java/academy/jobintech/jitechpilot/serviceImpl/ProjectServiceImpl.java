package academy.jobintech.jitechpilot.serviceImpl;

import academy.jobintech.jitechpilot.dto.pagination.PaginationResponseProject;
import academy.jobintech.jitechpilot.dto.request.ProjectRequest;
import academy.jobintech.jitechpilot.dto.response.ProjectResponse;
import academy.jobintech.jitechpilot.repository.ProjectRepository;
import academy.jobintech.jitechpilot.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectServiceImpl implements ProjectService {
    @Autowired
    private ProjectRepository projectRepository;
    @Override
    public ProjectResponse createProject(ProjectRequest projectRequest) {
        return null;
    }

    @Override
    public ProjectResponse getProjectById(Long projectId) {

        return null;
    }

    @Override
    public PaginationResponseProject getAllProjects(int pageNo, int pageSize, String sortBy, String sortDir) {
        return null;
    }

    @Override
    public ProjectResponse updateProject(Long projectId, ProjectRequest projectRequest) {
        return null;
    }

    @Override
    public void deleteProject(Long projectId) {

    }
}
