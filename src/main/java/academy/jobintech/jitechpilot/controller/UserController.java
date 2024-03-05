package academy.jobintech.jitechpilot.controller;

import academy.jobintech.jitechpilot.dto.UserRequestDto;
import academy.jobintech.jitechpilot.dto.UserResponseDto;
import academy.jobintech.jitechpilot.serviceImpl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/users")
@CrossOrigin(
        origins ={"http://localhost:3000","https://jiteck-pilot.vercel.app/"} ,
        allowedHeaders = "*",
        methods = {RequestMethod.GET,RequestMethod.DELETE,RequestMethod.POST,RequestMethod.PUT}
)
public class UserController {

    @Autowired
    private UserServiceImpl userService;
    @PostMapping
    private ResponseEntity<UserResponseDto> createUser(@RequestBody UserRequestDto userRequestDto) {
        UserResponseDto studentResponse = userService.createUser(userRequestDto);
        return new ResponseEntity<>(studentResponse, HttpStatus.CREATED);
    }

    @GetMapping
    private ResponseEntity<List<UserResponseDto>> getAllUser() {
        return ResponseEntity.ok(userService.getAllUsers());
    }


    @GetMapping("/{userId}")
    private ResponseEntity<UserResponseDto> getUserbyId(@PathVariable long userId) {
        return ResponseEntity.ok(userService.getUserById(userId));
    }

    @PutMapping("/{userId}")
    private ResponseEntity<UserResponseDto> getUserbyId(@PathVariable long userId, @RequestBody UserRequestDto userRequestDto) {
        UserResponseDto userResponseDto=userService.updateUser(userId,userRequestDto);

        return new  ResponseEntity<>(userResponseDto,HttpStatus.OK);
    }

    @DeleteMapping("/{userId}")
    private ResponseEntity<String> deleteUserbyId(@PathVariable long userId) {
        userService.deleteUser(userId);
        return new ResponseEntity<>("user deleted successfully",HttpStatus.OK);
    }


//    @PostMapping("/{userId}/teams/{teamId}")
//    private ResponseEntity<String> affecterUserToTeam(@PathVariable long userId,@PathVariable long teamId) {
//         userService.affecterUserToTeam(userId,teamId);
//        return new ResponseEntity<>("user affected successfully",HttpStatus.OK);
//    }
//
//    @GetMapping("/teams/{teamId}/users")
//    public List<UserResponseDto> getUsersByTeam(@PathVariable long teamId) {
//        return userService.getUsersByTeam(teamId);
//    }

}
