package academy.jobintech.jitechpilot.serviceImpl;

import academy.jobintech.jitechpilot.dto.TaskDTO;
import academy.jobintech.jitechpilot.entity.Task;
import academy.jobintech.jitechpilot.exception.NotFoundException;
import academy.jobintech.jitechpilot.mapper.TaskDTOMapper;
import academy.jobintech.jitechpilot.repository.TaskRepository;
import academy.jobintech.jitechpilot.service.TaskService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final TaskDTOMapper taskDTOMapper;

    public TaskServiceImpl(TaskRepository taskRepository, TaskDTOMapper taskDTOMapper) {
        this.taskRepository = taskRepository;
        this.taskDTOMapper = taskDTOMapper;
    }


    @Override
    public TaskDTO createTask(TaskDTO taskDTO) {
        Task task = taskDTOMapper.toEntity(taskDTO);
        Task savedTask = taskRepository.save(task);
        return taskDTOMapper.toDto(savedTask);
    }


    @Override
    public TaskDTO updateTask(Long id, TaskDTO taskDTO) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Task not found on id: " + id));

        task.setTitle(taskDTO.getTitle());
        task.setDescription(taskDTO.getDescription());
        task.setStatus(taskDTO.getStatus());
        task.setDeadline(taskDTO.getDeadline());

        Task updatedTask = taskRepository.save(task);
        log.info("Task with id: {} has been updated successfully", id);
        return taskDTOMapper.toDto(updatedTask);
    }

    @Override
    public void deleteTask(Long id) {
        log.info("Task with id: {} has been deleted successfully", id);
        taskRepository.deleteById(id);
    }

    /* TODO:
        1 - NotFoundException Handling
     */
    @Override
    public TaskDTO getTaskById(Long id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Task not found on :: " + id));
        log.info("Fetching task with id: {}...", id);
        return taskDTOMapper.toDto(task);
    }

    @Override
    public List<TaskDTO> getAllTasks() {
        log.info("Fetching all tasks...");
        return taskDTOMapper.toDtos(taskRepository.findAll());
    }



}
