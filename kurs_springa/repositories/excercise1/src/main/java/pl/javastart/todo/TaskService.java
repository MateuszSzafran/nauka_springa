package pl.javastart.todo;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.javastart.todo.dto.FullTaskInfoDto;
import pl.javastart.todo.dto.NewTaskDto;
import pl.javastart.todo.dto.TaskDurationDto;
import pl.javastart.todo.exceptions.TaskAlreadyCompletedException;
import pl.javastart.todo.exceptions.TaskNotFoundException;
import pl.javastart.todo.exceptions.TaskAlreadyStartedException;
import pl.javastart.todo.exceptions.TaskNotStartedException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
class TaskService {

    private final TaskRepository taskRepository;
    private static long nextId = 0;

    public TaskService(TaskRepository taskRepository){
        this.taskRepository = taskRepository;
    }

    @Transactional
    public Long createTask(NewTaskDto newTaskDto) {
        nextId++;
        Task task = new Task(nextId, newTaskDto.getTitle(), newTaskDto.getDescription(), newTaskDto.getPriority());
        taskRepository.save(task);
        return task.getId();
    }

    public Optional<String> getTaskInfo(long id) {
        Optional<Task> byId = taskRepository.findById(id);
        return byId.map(Task::toString);
    }

    public List<String> getNotStartedTasksInfo() {
        List<Task> tasks = taskRepository.findAllByStartTimeIsNullOrderByPriorityDesc();
        return tasks.stream().map(Task::toString).collect(Collectors.toList());
    }

    public List<FullTaskInfoDto> getCompletedTasks() {
        List<Task> tasks = taskRepository.findAllByCompletionTimeIsNotNullOrderByCompletionTime();
        return tasks.stream().map(this::toFullTaskInfoDto).collect(Collectors.toList());
    }

    private FullTaskInfoDto toFullTaskInfoDto(Task task) {
        return new FullTaskInfoDto(task.getId(), task.getTitle(), task.getDescription(), task.getPriority(), task.getStartTime(), task.getCompletionTime());
    }


    @Transactional
    public LocalDateTime startTask(Long taskId) {
        Optional<Task> optionalTask = taskRepository.findById(taskId);
        if (optionalTask.isEmpty()) {
            throw new TaskNotFoundException();
        } else if (optionalTask.get().getStartTime() != null) {
            throw new TaskAlreadyStartedException();
        } else {
            Task task = optionalTask.get();
            task.setStartTime(LocalDateTime.now());
            return task.getStartTime();
        }
    }

    @Transactional
    public TaskDurationDto endTask(Long taskId) {
        Optional<Task> optionalTask = taskRepository.findById(taskId);

        Task task = optionalTask.orElseThrow(TaskNotFoundException::new);

        if (task.getStartTime() == null) {
            throw new TaskNotStartedException();
        } else if (task.getCompletionTime() != null) {
            throw new TaskAlreadyCompletedException();
        } else {
            task.setCompletionTime(LocalDateTime.now());
            return new TaskDurationDto(task.getStartTime(), task.getCompletionTime());
        }
    }

}
