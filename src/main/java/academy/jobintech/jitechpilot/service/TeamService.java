package academy.jobintech.jitechpilot.service;

import academy.jobintech.jitechpilot.dto.pagination.PaginationResponseTeam;
import academy.jobintech.jitechpilot.dto.request.TeamRequest;
import academy.jobintech.jitechpilot.dto.response.TeamResponse;

public interface TeamService {
    TeamResponse createTeam(TeamRequest teamRequest);
    TeamResponse getTeamById(Long teamId);
    PaginationResponseTeam getAllTeams(int pageNo , int pageSize , String sortBy , String sortDir);
    TeamResponse updateTeam(Long teamId, TeamRequest teamRequest);
    void deleteTeam(Long teamId);
}
