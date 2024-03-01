package academy.jobintech.jitechpilot.serviceImpl;

import academy.jobintech.jitechpilot.dto.ResponseTeamPage;
import academy.jobintech.jitechpilot.dto.TeamDTO;
import academy.jobintech.jitechpilot.entity.Team;
import academy.jobintech.jitechpilot.mapper.TeamEntityDTOMapper;
import academy.jobintech.jitechpilot.repository.TeamRepository;
import academy.jobintech.jitechpilot.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TeamServiceImpl implements TeamService {
    @Autowired
    private TeamRepository teamRepository;
    @Autowired
    private TeamEntityDTOMapper teamMapper;
    @Override
    public TeamDTO createTeam(TeamDTO teamDTO) {
        Team team = teamMapper.toEntity(teamDTO);
        Team createdTeam = teamRepository.save(team);
        return teamMapper.toDto(createdTeam);
    }

    @Override
    public TeamDTO getTeamById(Long teamId) {
        Team team = getTeamByIdHelper(teamId);
        return teamMapper.toDto(team);
    }

    //I Create this Method to not deplucate findById -orElse null
    @Override
    public Team getTeamByIdHelper(Long teamId) {
        Team team = teamRepository.findById(teamId)
                .orElseThrow(() -> new RuntimeException("Team not found on :: " + teamId));
        return team;
    }

    @Override
    public ResponseTeamPage getAllTeams(int pageNo, int pageSize, String sortBy, String sortDir) {
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(pageNo,pageSize, sort);
        Page<Team> teamPage = teamRepository.findAll(pageable);
        List<Team> teamList = teamPage.getContent();
        List<TeamDTO> teamResponseList = teamList.stream()
                .map((team) -> teamMapper.toDto(team))
                .collect(Collectors.toList());

        ResponseTeamPage responseTeamPage = new ResponseTeamPage(
                teamResponseList,
                teamPage.getNumber(),
                teamPage.getSize(),
                teamPage.getTotalElements(),
                teamPage.getTotalPages(),
                teamPage.isLast()
        );

        return responseTeamPage;
    }

    @Override
    public TeamDTO updateTeam(Long teamId, TeamDTO teamDTO) {
        Team teamToUpdate = getTeamByIdHelper(teamId);
        if (teamToUpdate != null){
            //BeanUtils.copyProperties(teamDTO,teamToUpdate);
            teamToUpdate.setTeamName(teamDTO.getTeamName());
            teamToUpdate.setDescription(teamDTO.getDescription());
            Team updatedTeam = teamRepository.save(teamToUpdate);
            return teamMapper.toDto(updatedTeam);
        }
        return null;
    }

    @Override
    public void deleteTeam(Long teamId) {
        Team teamToDelete = getTeamByIdHelper(teamId);
        if (teamToDelete!=null) teamRepository.delete(teamToDelete);
    }
}
