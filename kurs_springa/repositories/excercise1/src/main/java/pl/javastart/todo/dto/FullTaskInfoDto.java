package pl.javastart.todo.dto;

import java.time.LocalDateTime;

public class FullTaskInfoDto extends NewTaskDto{

    private final Long id;
    private final LocalDateTime startTime;
    private final LocalDateTime completeTime;

    public FullTaskInfoDto(Long id, String title, String description, int priority, LocalDateTime startTime, LocalDateTime completeTime) {
        super(title, description, priority);
        this.id = id;
        this.startTime = startTime;
        this.completeTime = completeTime;
    }

    @Override
    public String toString() {
        return String.format("Zadanie %s: %s (%s). Priorytet: %s. Rozpoczęte: %s / Zakończone: %s", id, super.getTitle(), super.getDescription(), super.getPriority(), startTime, completeTime);
    }
}
