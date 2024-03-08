package academy.jobintech.jitechpilot.serviceImpl;

import academy.jobintech.jitechpilot.dto.UserBoardRoleDTO;
import academy.jobintech.jitechpilot.entity.Board;
import academy.jobintech.jitechpilot.entity.RoleBoardId;
import academy.jobintech.jitechpilot.entity.User;
import academy.jobintech.jitechpilot.entity.UserBoardRole;
import academy.jobintech.jitechpilot.enums.UserRole;
import academy.jobintech.jitechpilot.exception.NotFoundException;
import academy.jobintech.jitechpilot.mapper.UserBoardRoleDTOMapper;
import academy.jobintech.jitechpilot.repository.UserBoardRoleRepository;
import academy.jobintech.jitechpilot.service.UserBoardRoleService;
import org.hibernate.query.sql.internal.ParameterRecognizerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserBoardRoleServiceImpl implements UserBoardRoleService {
    @Autowired
    private UserBoardRoleRepository userBoardRoleRepository;
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private BoardServiceImpl boardService;
    @Autowired
    private UserBoardRoleDTOMapper userBoardRoleDTOMapper;
    @Override
    public UserBoardRoleDTO assignBoardRoleToUser(UserBoardRoleDTO userBoardRoleDTO) {
        User user = userService.getUsertByIdHelper(userBoardRoleDTO.getUserId());
        Board board = boardService.getBoardByIdHelper(userBoardRoleDTO.getBoardId());
        RoleBoardId roleBoardId = new RoleBoardId(userBoardRoleDTO.getUserId(),userBoardRoleDTO.getBoardId());
        UserBoardRole userBoardRole = new UserBoardRole(
                roleBoardId,
                user,
                board,
                userBoardRoleDTO.getUserRole()
        );
        UserBoardRole saveUserBoardRole = userBoardRoleRepository.save(userBoardRole);

        return userBoardRoleDTOMapper.toDto(saveUserBoardRole);
    }
    public UserBoardRole getUserBoardRole(Long userId , Long boardId) {
        User user = userService.getUsertByIdHelper(userId);
        Board board = boardService.getBoardByIdHelper(boardId);
        RoleBoardId roleBoardId = new RoleBoardId(userId , boardId);
        UserBoardRole userBoardRole = userBoardRoleRepository.findById(roleBoardId)
                .orElseThrow(() -> new NotFoundException("UserBoardRole not found on id: " + roleBoardId));
        return userBoardRole;
    }

    @Override
    public UserBoardRoleDTO updateBoardRoleToUser(UserBoardRoleDTO userBoardRoleDTO) {
        UserBoardRole userBoardRole = getUserBoardRole(userBoardRoleDTO.getUserId() , userBoardRoleDTO.getBoardId());
        userBoardRole.setUser_role(userBoardRoleDTO.getUserRole());
        UserBoardRole savedUserBoardRole = userBoardRoleRepository.save(userBoardRole);
        return userBoardRoleDTOMapper.toDto(savedUserBoardRole);
    }

    @Override
    public void deleteUserBoardRoleByBoardId(Long board_id) {
        List<UserBoardRole> userBoardRoles = userBoardRoleRepository.findByboardBoardId(board_id);
        userBoardRoleRepository.deleteAll(userBoardRoles);
    }


}
