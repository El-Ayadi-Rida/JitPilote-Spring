package academy.jobintech.jitechpilot.mapper;

import academy.jobintech.jitechpilot.dto.request.ProjectRequest;
import academy.jobintech.jitechpilot.dto.response.ProjectResponse;
import academy.jobintech.jitechpilot.entity.Project;
import org.modelmapper.ModelMapper;

public class ProjectMapper implements Mapper<Project, ProjectResponse , ProjectRequest>{
    private ModelMapper modelMapper = new ModelMapper();
    @Override
    public Project toEntity(ProjectRequest request) {
        return modelMapper.map(request , Project.class);
    }

    @Override
    public ProjectResponse toResponse(Project project) {
        return modelMapper.map(project , ProjectResponse.class);
    }
}
