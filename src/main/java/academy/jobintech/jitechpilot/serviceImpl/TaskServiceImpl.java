package academy.jobintech.jitechpilot.serviceImpl;

import academy.jobintech.jitechpilot.dto.TaskDTO;
import academy.jobintech.jitechpilot.entity.Task;
import academy.jobintech.jitechpilot.mapper.TaskDTOMapper;
import academy.jobintech.jitechpilot.repository.TaskRepository;
import academy.jobintech.jitechpilot.service.TaskService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Yassine CHALH
 */
@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final TaskDTOMapper taskDTOMapper;

    public TaskServiceImpl(TaskRepository taskRepository, TaskDTOMapper taskDTOMapper) {
        this.taskRepository = taskRepository;
        this.taskDTOMapper = taskDTOMapper;
    }

    /* TODO:
        1 - change status type to an Enum (TaskStatus)
     */
    @Override
    public TaskDTO createTask(TaskDTO taskDTO) {
        Task task = taskDTOMapper.toEntity(taskDTO);
        Task savedTask = taskRepository.save(task);
        return taskDTOMapper.toDto(savedTask);
    }

    /* TODO:
        1 - NotFoundException Handling
        2 - In case of it doesnt exist we must create it
     */
    @Override
    public TaskDTO updateTask(Long id, TaskDTO taskDTO) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found on :: " + id));

        task.setTitle(taskDTO.getTitle());
        task.setDescription(taskDTO.getDescription());
        task.setStatus(taskDTO.getStatus());
        task.setDeadline(taskDTO.getDeadline());

        Task updatedTask = taskRepository.save(task);

        return taskDTOMapper.toDto(updatedTask);
    }

    @Override
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    /* TODO:
        1 - NotFoundException Handling
     */
    @Override
    public TaskDTO getTaskById(Long id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found on :: " + id));
        return taskDTOMapper.toDto(task);
    }

    @Override
    public List<TaskDTO> getAllTasks() {
        return taskDTOMapper.toDtos(taskRepository.findAll());
    }

}
