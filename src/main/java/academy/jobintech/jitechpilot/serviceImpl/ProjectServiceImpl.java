package academy.jobintech.jitechpilot.serviceImpl;

import academy.jobintech.jitechpilot.dto.ResponseProjectPage;
import academy.jobintech.jitechpilot.dto.ProjectDTO;
import academy.jobintech.jitechpilot.entity.Project;
import academy.jobintech.jitechpilot.mapper.ProjectMapper;
import academy.jobintech.jitechpilot.repository.ProjectRepository;
import academy.jobintech.jitechpilot.service.ProjectService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjectServiceImpl implements ProjectService {
    @Autowired
    private ProjectRepository projectRepository;
    @Autowired
    private ProjectMapper projectMapper;
    @Override
    public ProjectDTO createProject(ProjectDTO projectDTO) {
        Project project = projectMapper.toEntity(projectDTO);
        Project createdProject = projectRepository.save(project);
        return projectMapper.toResponse(createdProject);
    }

    @Override
    public ProjectDTO getProjectById(Long projectId) {
        Project project = getProjectByIdHelper(projectId);
        return projectMapper.toResponse(project);
    }

    @Override
    public Project getProjectByIdHelper(Long projectId) {
        Project projectById = projectRepository.findById(projectId)
                .orElseThrow(() -> new RuntimeException("Project not found on :: " + projectId));
        return projectById;
    }

    @Override
    public ResponseProjectPage getAllProjects(int pageNo, int pageSize, String sortBy, String sortDir) {
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(pageNo,pageSize, sort);
        Page<Project> projectPage = projectRepository.findAll(pageable);
        List<Project> projectList = projectPage.getContent();
        List<ProjectDTO> projectResponseList = projectList.stream()
                .map((project) -> projectMapper.toResponse(project))
                .collect(Collectors.toList());

        ResponseProjectPage responseProjectPage = new ResponseProjectPage(
                projectResponseList,
                projectPage.getNumber(),
                projectPage.getSize(),
                projectPage.getTotalElements(),
                projectPage.getTotalPages(),
                projectPage.isLast()
        );

        return responseProjectPage;
    }

    @Override
    public ProjectDTO updateProject(Long projectId, ProjectDTO projectDTO) {
        Project projectToUpdate = getProjectByIdHelper(projectId);
        if (projectToUpdate!=null){
            // to copy properties from DTO to ENTITY
            //BeanUtils.copyProperties(projectDTO,projectToUpdate);
            projectToUpdate.setProjectName(projectDTO.getProjectName());
            projectToUpdate.setDescription(projectDTO.getDescription());
            Project updatedProject = projectRepository.save(projectToUpdate);
            return projectMapper.toResponse(updatedProject);
        }
        return null;
    }

    @Override
    public void deleteProject(Long projectId) {
        Project projectToDelete = getProjectByIdHelper(projectId);
        if (projectToDelete!=null) projectRepository.delete(projectToDelete);
    }
}
