package academy.jobintech.jitechpilot.controller;

import academy.jobintech.jitechpilot.dto.SectionDTO;
import academy.jobintech.jitechpilot.dto.UserRequestDto;
import academy.jobintech.jitechpilot.dto.UserResponseDto;
import academy.jobintech.jitechpilot.serviceImpl.SectionServiceImpl;
import academy.jobintech.jitechpilot.serviceImpl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
@CrossOrigin(
        origins = "http://localhost:3000" ,
        allowedHeaders = "*",
        methods = {RequestMethod.GET,RequestMethod.DELETE,RequestMethod.POST,RequestMethod.PUT}
)
public class SectionController {

    @Autowired
    private SectionServiceImpl sectionService;

    @PostMapping("/boards/{boardId}/sections")
    private ResponseEntity<SectionDTO> createSectionInBoard(@PathVariable long boardId, @RequestBody SectionDTO sectionDTO) {
        SectionDTO sectioncreated = sectionService.createSection(boardId,sectionDTO);
        return new ResponseEntity<>(sectioncreated, HttpStatus.CREATED);
    }

    @GetMapping("/boards/{boardId}/sections")
    public List<SectionDTO> getSectionsByBoards(@PathVariable long boardId) {
        return sectionService.getSectionByBoards(boardId);
    }


    @GetMapping("/sections")
    private ResponseEntity<List<SectionDTO>> getAllSection() {
        return ResponseEntity.ok(sectionService.getAllSection());
    }


    @GetMapping("/sections/{sectionId}")
    private ResponseEntity<SectionDTO> getSectionbyId(@PathVariable long sectionId) {
        return ResponseEntity.ok(sectionService.getSectionById(sectionId));
    }



    @PutMapping("/sections/{sectionId}")
    private ResponseEntity<SectionDTO> getSectionbyId(@PathVariable long sectionId, @RequestBody SectionDTO sectionDTO) {
        SectionDTO sectionDTO1=sectionService.updateSection(sectionId,sectionDTO);

        return new  ResponseEntity<>(sectionDTO1,HttpStatus.OK);
    }

    @DeleteMapping("/sections/{sectionId}")
    private ResponseEntity<String> deleteSectionbyId(@PathVariable long sectionId) {
        sectionService.deleteSection(sectionId);
        return new ResponseEntity<>("section deleted successfully",HttpStatus.OK);
    }

    @PostMapping("/boards/{boardId}/sections/{sectionId}")
    private ResponseEntity<String> assignSectionToBoard(@PathVariable long sectionId,@PathVariable long boardId) {
        sectionService.assignSectionToBoard(sectionId,boardId);
        return new ResponseEntity<>("section assign to board successfully",HttpStatus.OK);
    }


}
