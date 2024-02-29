package academy.jobintech.jitechpilot.serviceImpl;

import academy.jobintech.jitechpilot.dto.pagination.PaginationResponseTeam;
import academy.jobintech.jitechpilot.dto.request.TeamRequest;
import academy.jobintech.jitechpilot.dto.response.TeamResponse;
import academy.jobintech.jitechpilot.repository.TeamRepository;
import academy.jobintech.jitechpilot.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeamServiceImpl implements TeamService {
    @Autowired
    private TeamRepository teamRepository;
    @Override
    public TeamResponse createTeam(TeamRequest teamRequest) {
        return null;
    }

    @Override
    public TeamResponse getTeamById(Long teamId) {
        return null;
    }

    @Override
    public PaginationResponseTeam getAllTeams(int pageNo, int pageSize, String sortBy, String sortDir) {
        return null;
    }

    @Override
    public TeamResponse updateTeam(Long teamId, TeamRequest teamRequest) {
        return null;
    }

    @Override
    public void deleteTeam(Long teamId) {

    }
}
