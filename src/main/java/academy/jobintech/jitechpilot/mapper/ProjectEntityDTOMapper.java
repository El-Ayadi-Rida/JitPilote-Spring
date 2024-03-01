package academy.jobintech.jitechpilot.mapper;

import academy.jobintech.jitechpilot.dto.ProjectDTO;
import academy.jobintech.jitechpilot.entity.Project;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ProjectEntityDTOMapper implements EntityDTOMapper<Project, ProjectDTO> {
    private ModelMapper modelMapper = new ModelMapper();
    @Override
    public Project toEntity(ProjectDTO dto) {
        return modelMapper.map(dto , Project.class);
    }

    @Override
    public ProjectDTO toDto(Project project) {
        return modelMapper.map(project , ProjectDTO.class);
    }
}
