package pl.javastart.todo.dto;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


public class TaskDurationDto {
    private final LocalDateTime startTime;
    private LocalDateTime completeTime;

    public TaskDurationDto(LocalDateTime startTime, LocalDateTime completeTime){
        this.startTime = startTime;
        this.completeTime = completeTime;
    }

    public void setCompleteTime(LocalDateTime completeTime) {
        this.completeTime = completeTime;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public LocalDateTime getCompleteTime() {
        return completeTime;
    }
}
