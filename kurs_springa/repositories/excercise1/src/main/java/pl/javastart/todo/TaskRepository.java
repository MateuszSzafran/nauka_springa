package pl.javastart.todo;

import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface TaskRepository extends CrudRepository<Task, Long> {
    List<Task> findAllByStartTimeIsNullOrderByPriorityDesc();
    List<Task> findAllByCompletionTimeIsNotNullOrderByCompletionTime();
}
