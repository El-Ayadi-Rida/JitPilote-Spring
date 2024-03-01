package academy.jobintech.jitechpilot.serviceImpl;

import academy.jobintech.jitechpilot.dto.UserRequestDto;
import academy.jobintech.jitechpilot.dto.UserResponseDto;
import academy.jobintech.jitechpilot.entity.Team;
import academy.jobintech.jitechpilot.entity.User;
import academy.jobintech.jitechpilot.mapper.UserRequestEntityDTOMapper;
import academy.jobintech.jitechpilot.mapper.UserResponseEntityDTOMapper;
import academy.jobintech.jitechpilot.repository.TeamRepository;
import academy.jobintech.jitechpilot.repository.UserRepository;
import academy.jobintech.jitechpilot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRequestEntityDTOMapper userRequestMapper;

    @Autowired
    private UserResponseEntityDTOMapper userResponseMapper;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TeamRepository teamRepository;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserServiceImpl(BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public UserResponseDto createUser(UserRequestDto userRequestDto) {
        User user =userRequestMapper.toEntity(userRequestDto);
        User newUser = userRepository.save(user);
        return userResponseMapper.toDto(newUser);
    }

    @Override
    public UserResponseDto getUserById(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(()->new RuntimeException("user not found "));

        return userResponseMapper.toDto(user);
    }

    @Override
    public List<UserResponseDto> getAllUsers() {
        List<User> userList=userRepository.findAll();
        return userResponseMapper.toDtos(userList);
    }

    @Override
    public UserResponseDto  updateUser(Long userId, UserRequestDto userRequestDto) {
        User user = userRepository.findById(userId).orElseThrow(()->new RuntimeException("user not found"));
        user.setFirstName(userRequestDto.getFirstName());
        user.setLastName(userRequestDto.getLastName());
        user.setUserName(userRequestDto.getUserName());
        user.setEmail(userRequestDto.getEmail());
        user.setPassword(bCryptPasswordEncoder.encode(userRequestDto.getPassword()));


        User updateUser=userRepository.save(user);
        return userResponseMapper.toDto(updateUser);
    }

    @Override
    public void deleteUser(Long userId) {

        getUserById(userId);
        userRepository.deleteById(userId);


    }

    @Override
    public void affecterUserToTeam(long userId, long teamId) {
        User user = userRepository.findById(userId).orElseThrow(()->new RuntimeException("user not found"));
        Team team =teamRepository.findById(teamId).orElseThrow(()->new RuntimeException("team not found"));

        user.setTeam(team);

        userRepository.save(user);
    }
}
