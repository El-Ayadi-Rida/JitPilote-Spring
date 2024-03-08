package academy.jobintech.jitechpilot.serviceImpl;


import academy.jobintech.jitechpilot.dto.WorkspaceDTO;
import academy.jobintech.jitechpilot.entity.Workspace;
import academy.jobintech.jitechpilot.exception.NotFoundException;
import academy.jobintech.jitechpilot.mapper.WorkspaceDTOMapper;
import academy.jobintech.jitechpilot.repository.WorkspaceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class WorkspaceService {

    private final WorkspaceRepository workspaceRepository;
    private final WorkspaceDTOMapper workspaceDTOMapper;

    @Autowired
    public WorkspaceService(WorkspaceRepository workspaceRepository, WorkspaceDTOMapper workspaceDTOMapper) {
        this.workspaceRepository = workspaceRepository;
        this.workspaceDTOMapper = workspaceDTOMapper;
    }

    public List<WorkspaceDTO> getAllWorkspaces() {
        System.out.println(workspaceRepository.findAll());
        return workspaceDTOMapper.toDtos(workspaceRepository.findAll());
    }

    public WorkspaceDTO getWorkspaceById(Long id) {
        Workspace workspace = workspaceRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Workspace not found with id : " + id));
        return workspaceDTOMapper.toDto(workspace);

    }
    public Workspace getWorkspaceByIdHelper(Long id) {
        Workspace workspace = workspaceRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Workspace not found with id : " + id));
        return workspace;

    }

    public WorkspaceDTO createWorkspace(WorkspaceDTO workspaceDto) {
        Workspace workspace = workspaceDTOMapper.toEntity(workspaceDto);
        workspace = workspaceRepository.save(workspace);
        return  workspaceDTOMapper.toDto(workspace);
    }

    public WorkspaceDTO updateWorkspace(Long id, WorkspaceDTO workspaceDto) {
        Workspace workspace = workspaceRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Workspace not found for this id :: " + id));
        workspace.setName(workspaceDto.getName());
        workspace.setDescription(workspaceDto.getDescription());
        workspace = workspaceRepository.save(workspace);
        return workspaceDTOMapper.toDto(workspace);
    }

    public void deleteWorkspace(Long id) {
        workspaceRepository.deleteById(id);
    }


}