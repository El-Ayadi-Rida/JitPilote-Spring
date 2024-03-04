package academy.jobintech.jitechpilot.controller;

import academy.jobintech.jitechpilot.dto.ResponseTeamPage;
import academy.jobintech.jitechpilot.dto.TeamDTO;
import academy.jobintech.jitechpilot.serviceImpl.TeamServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/teams")
@CrossOrigin(
        origins = {"http://localhost:3000","https://jiteck-pilot.vercel.app/"},
        allowedHeaders = "*",
        methods = {RequestMethod.GET,RequestMethod.DELETE,RequestMethod.POST,RequestMethod.PUT}
)
public class TeamController {
    @Autowired
    private TeamServiceImpl teamService;

    @PostMapping("/create")
    public ResponseEntity<TeamDTO> createTeam(
            @RequestBody TeamDTO teamDTO
            ){
        TeamDTO newTeam = teamService.createTeam(teamDTO);
        return new ResponseEntity<>(newTeam , HttpStatus.CREATED);
    }

    @GetMapping("/{team_id}")
    public ResponseEntity<TeamDTO> getTeamById(@PathVariable Long team_id){
        TeamDTO teamResponse = teamService.getTeamById(team_id);
        return new ResponseEntity<>(teamResponse , HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<ResponseTeamPage>  getAllTeams(
            @RequestParam(name = "pageNo" ,defaultValue = "0" ,required = false) int pageNo,
            @RequestParam(name = "pageSize" ,defaultValue = "5" ,required = false) int pageSize,
            @RequestParam(name = "sortBy" ,defaultValue = "teamId" ,required = false) String sortBy,
            @RequestParam(name = "sortDir" ,defaultValue = "asc" ,required = false) String sortDir
    ){
        return ResponseEntity.ok(teamService.getAllTeams(pageNo, pageSize , sortBy , sortDir));
    }

    @PutMapping("/update/{team_id}")
    public ResponseEntity<TeamDTO> updateTeam(
            @RequestBody TeamDTO teamDTO,
            @PathVariable("team_id") Long team_id){
        TeamDTO updatedTeam = teamService.updateTeam(team_id , teamDTO);
        return new ResponseEntity<>(updatedTeam , HttpStatus.OK);
    }

    @DeleteMapping("/delete/{team_id}")
    public ResponseEntity<String> deleteTeam(@PathVariable("team_id") Long team_id){
        teamService.deleteTeam(team_id);
        return ResponseEntity.ok("Team with Id: "+team_id+" deleted successfully");
    }
}
