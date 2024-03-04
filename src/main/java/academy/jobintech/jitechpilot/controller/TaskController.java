package academy.jobintech.jitechpilot.controller;

import academy.jobintech.jitechpilot.dto.TaskDTO;
import academy.jobintech.jitechpilot.service.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/v1/tasks")
@CrossOrigin(
        origins = {"http://localhost:3000","https://jiteck-pilot.vercel.app/"},
        allowedHeaders = "*",
        methods = {RequestMethod.GET,RequestMethod.DELETE,RequestMethod.POST,RequestMethod.PUT}
)
public class TaskController{

    private final TaskService taskService;

    public TaskController(TaskService taskService){
        this.taskService = taskService;
    }

    @PostMapping("create/{ticketId}")
    public ResponseEntity<TaskDTO> createTask(@PathVariable Long ticketId, @RequestBody TaskDTO taskDTO) {
        TaskDTO createdTask = taskService.createTask(ticketId,taskDTO);
        return new ResponseEntity<>(createdTask, HttpStatus.CREATED);
    }

    @GetMapping("get/{id}")
    public ResponseEntity<TaskDTO> getTaskById(@PathVariable Long id) {
        TaskDTO taskDTO = taskService.getTaskById(id);
        return ResponseEntity.ok(taskDTO);
    }

    @GetMapping("all")
    public ResponseEntity<List<TaskDTO>> getAllTasks() {
        List<TaskDTO> tasks = taskService.getAllTasks();
        return ResponseEntity.ok(tasks);
    }

    @GetMapping("ticket/{ticketId}")
    public ResponseEntity<List<TaskDTO>> getTasksByTicket(@PathVariable Long ticketId) {
        List<TaskDTO> tasks = taskService.getTasksByTicketId(ticketId);
        return ResponseEntity.ok(tasks);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TaskDTO> updateTask(@PathVariable Long id, @RequestBody TaskDTO taskDTO) {
        TaskDTO updatedTask = taskService.updateTask(id, taskDTO);
        return ResponseEntity.ok(updatedTask);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return ResponseEntity.noContent().build();
    }
}
