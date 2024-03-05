package academy.jobintech.jitechpilot.controller;

import academy.jobintech.jitechpilot.dto.BoardDTO;
import academy.jobintech.jitechpilot.dto.ResponseBoardPage;
import academy.jobintech.jitechpilot.serviceImpl.BoardServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/boards")
@CrossOrigin(
        origins = {"http://localhost:3000","https://jiteck-pilot.vercel.app/"},
        allowedHeaders = "*",
        methods = {RequestMethod.GET,RequestMethod.DELETE,RequestMethod.POST,RequestMethod.PUT}
)
public class BoardController {
    @Autowired
    private BoardServiceImpl boardService;

    @PostMapping
    public ResponseEntity<BoardDTO> createBoard(
            @RequestBody BoardDTO boardDTO
    ){
        BoardDTO newBoard = boardService.createBoard(boardDTO);
        return new ResponseEntity<>(newBoard , HttpStatus.CREATED);
    }

    @GetMapping("/{boardId}")
    public ResponseEntity<BoardDTO> getBoardById(@PathVariable("boardId") Long boardId){
        BoardDTO boardDTOResponse = boardService.getBoardById(boardId);
        return new ResponseEntity<>(boardDTOResponse, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<ResponseBoardPage>  getAllBoards(
            @RequestParam(name = "pageNo" ,defaultValue = "0" ,required = false) int pageNo,
            @RequestParam(name = "pageSize" ,defaultValue = "5" ,required = false) int pageSize,
            @RequestParam(name = "sortBy" ,defaultValue = "boardId" ,required = false) String sortBy,
            @RequestParam(name = "sortDir" ,defaultValue = "asc" ,required = false) String sortDir
    ){
        return ResponseEntity.ok(boardService.getAllBoards(pageNo, pageSize , sortBy , sortDir));
    }

    @PutMapping("/{boardId}")
    public ResponseEntity<BoardDTO> updateBoard(
            @RequestBody BoardDTO boardDTO,
            @PathVariable("boardId") Long boardId){
        BoardDTO updatedBoard = boardService.updateBoard(boardId , boardDTO);
        return new ResponseEntity<>(updatedBoard , HttpStatus.OK);
    }

    @DeleteMapping("/{boardId}")
    public ResponseEntity<String> deleteBoard(@PathVariable("boardId") Long boardId){
        boardService.deleteBoard(boardId);
        return ResponseEntity.ok("Board with Id: "+boardId+" deleted successfully");
    }

    @PostMapping("/{userId}/board")
    public ResponseEntity<BoardDTO> createBoardByUser(@PathVariable Long userId,
            @RequestBody BoardDTO boardDTO
    ){
        BoardDTO newBoard = boardService.createBoardByUser(userId,boardDTO);
        return new ResponseEntity<>(newBoard , HttpStatus.CREATED);
    }
}
