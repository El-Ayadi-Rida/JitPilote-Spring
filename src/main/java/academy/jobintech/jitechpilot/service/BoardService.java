package academy.jobintech.jitechpilot.service;

import academy.jobintech.jitechpilot.dto.BoardDTO;
import academy.jobintech.jitechpilot.dto.ResponseBoardPage;

/**
 * @author Yassine CHALH
 */
public interface BoardService {
    BoardDTO createBoard(BoardDTO boardDTO);

    BoardDTO getBoardById(Long boardId);

    ResponseBoardPage getAllBoards(int pageNo, int pageSize, String sortBy, String sortDir);

    //TODO: Create project if not exists
    BoardDTO updateBoard(Long boardId, BoardDTO boardDTO);

    void deleteBoard(Long boardId);

    BoardDTO createBoardByUser(Long userId,BoardDTO boardDTO);
}
