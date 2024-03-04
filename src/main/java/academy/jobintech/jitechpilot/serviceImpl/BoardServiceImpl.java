package academy.jobintech.jitechpilot.serviceImpl;

import academy.jobintech.jitechpilot.dto.ResponseBoardPage;
import academy.jobintech.jitechpilot.dto.BoardDTO;
import academy.jobintech.jitechpilot.entity.Board;
import academy.jobintech.jitechpilot.exception.NotFoundException;
import academy.jobintech.jitechpilot.mapper.BoardDTOMapper;
import academy.jobintech.jitechpilot.repository.BoardRepository;
import academy.jobintech.jitechpilot.service.BoardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class BoardServiceImpl implements BoardService {
    @Autowired
    private BoardRepository boardRepository;
    @Autowired
    private BoardDTOMapper boardMapper;
    @Override
    public BoardDTO createBoard(BoardDTO boardDTO) {
        Board board = boardMapper.toEntity(boardDTO);
        Board createdBoard = boardRepository.save(board);
        log.info("Board created successfully");
        return boardMapper.toDto(createdBoard);
    }

    @Override
    public BoardDTO getBoardById(Long boardId) {
        Board board = getBoardByIdHelper(boardId);
        log.info("Fetching board by id: {} ", boardId);
        return boardMapper.toDto(board);
    }

    public Board getBoardByIdHelper(Long boardId) {
        Board boardById = boardRepository.findById(boardId)
                .orElseThrow(() -> new NotFoundException("Board not found on :: " + boardId));
        log.info("Not found: {}", boardById);
        return boardById;
    }

    @Override
    public ResponseBoardPage getAllBoards(int pageNo, int pageSize, String sortBy, String sortDir) {
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(pageNo,pageSize, sort);
        Page<Board> boardPage = boardRepository.findAll(pageable);
        List<Board> boardList = boardPage.getContent();
        List<BoardDTO> boardResponseList = boardList.stream()
                .map((board) -> boardMapper.toDto(board))
                .collect(Collectors.toList());

        ResponseBoardPage responseBoardPage = new ResponseBoardPage(
                boardResponseList,
                boardPage.getNumber(),
                boardPage.getSize(),
                boardPage.getTotalElements(),
                boardPage.getTotalPages(),
                boardPage.isLast()
        );

        return responseBoardPage;
    }

    //TODO: Create board if not exists
    @Override
    public BoardDTO updateBoard(Long boardId, BoardDTO boardDTO) {
        Board boardToUpdate = getBoardByIdHelper(boardId);
            // to copy properties from DTO to ENTITY
            //BeanUtils.copyProperties(projectDTO,projectToUpdate);
            boardToUpdate.setBoardName(boardDTO.getBoardName());
            boardToUpdate.setDescription(boardDTO.getDescription());
            Board updatedBoard = boardRepository.save(boardToUpdate);

            log.info("Board updated successfully with id: {} ", boardId);
            return boardMapper.toDto(updatedBoard);

    }

    @Override
    public void deleteBoard(Long boardId) {
        Board boardToDelete = getBoardByIdHelper(boardId);
        if (boardToDelete !=null) boardRepository.delete(boardToDelete);
        log.info("Board deleted successfully with id: {} ", boardId);
    }
}