package academy.jobintech.jitechpilot.service;

import academy.jobintech.jitechpilot.dto.ResponseTeamPage;
import academy.jobintech.jitechpilot.dto.TeamDTO;
import academy.jobintech.jitechpilot.entity.Team;

public interface TeamService {
    TeamDTO createTeam(TeamDTO teamDTO);
    TeamDTO getTeamById(Long teamId);
    Team getTeamByIdHelper(Long teamId);
    ResponseTeamPage getAllTeams(int pageNo , int pageSize , String sortBy , String sortDir);
    TeamDTO updateTeam(Long teamId, TeamDTO teamDTO);
    void deleteTeam(Long teamId);
}
