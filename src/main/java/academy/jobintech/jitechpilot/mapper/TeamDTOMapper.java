package academy.jobintech.jitechpilot.mapper;

import academy.jobintech.jitechpilot.dto.TeamDTO;
import academy.jobintech.jitechpilot.entity.Team;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class TeamDTOMapper implements EntityDTOMapper<Team, TeamDTO> {
    private ModelMapper modelMapper = new ModelMapper();
    @Override
    public Team toEntity(TeamDTO dto) {
        return modelMapper.map(dto,Team.class);
    }

    @Override
    public TeamDTO toDto(Team team) {
        return modelMapper.map(team,TeamDTO.class);
    }
}
