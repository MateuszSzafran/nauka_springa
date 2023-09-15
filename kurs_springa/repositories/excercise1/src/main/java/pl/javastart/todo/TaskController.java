package pl.javastart.todo;

import org.springframework.stereotype.Controller;
import pl.javastart.todo.dto.FullTaskInfoDto;
import pl.javastart.todo.dto.NewTaskDto;
import pl.javastart.todo.dto.TaskDurationDto;
import pl.javastart.todo.exceptions.TaskAlreadyCompletedException;
import pl.javastart.todo.exceptions.TaskAlreadyStartedException;
import pl.javastart.todo.exceptions.TaskNotFoundException;
import pl.javastart.todo.exceptions.TaskNotStartedException;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@Controller
class TaskController {

    private final Scanner scanner;
    private final TaskService taskService;

    public TaskController(Scanner scanner, TaskService taskService) {
        this.scanner = scanner;
        this.taskService = taskService;
    }

    public void loop() {
        Option option;
        do {
            printOptions();
            option = chooseOption();
            evaluateOption(option);
        } while (option != Option.EXIT);
    }

    private void printOptions() {
        System.out.println("\nWybierz opcję:");
        for (Option option : Option.values()) {
            System.out.println(option);
        }
    }

    private Option chooseOption() {
        int optionNumber = scanner.nextInt();
        scanner.nextLine();
        return Option.fromInt(optionNumber);
    }

    private void evaluateOption(Option option) {
        try {
            switch (option) {
                case ADD -> addTask();
                case PRINT_SINGLE -> printTask();
                case PRINT_NOT_STARTED -> printNotStartedTasks();
                case PRINT_FINISHED -> printFinishedTasks();
                case START_TASK -> startTask();
                case END_TASK -> endTask();
                case EXIT -> exit();
            }
        } catch (TaskNotFoundException e) {
            System.out.println("Brak zadania o podanym identyfikatorze.");
        }
    }

    private void printNotStartedTasks() {
       List<String> tasksInfo = taskService.getNotStartedTasksInfo();
       tasksInfo.forEach(System.out::println);
    }

    private void printFinishedTasks(){
        List<FullTaskInfoDto> tasks = taskService.getCompletedTasks();
        tasks.forEach(System.out::println);
    }

    private void startTask() {
        Long taskId = getIdFromUser();
        try {
            LocalDateTime startTime = taskService.startTask(taskId);
            System.out.println("Czas rozpoczęcia zadania: " + startTime);
        } catch (TaskAlreadyStartedException e) {
            System.out.println("Zadanie zostało już rozpoczęte.");
        }
    }

    private void addTask() {
        System.out.println("Podaj tytuł zadania:");
        String title = scanner.nextLine();
        System.out.println("Opis zadania:");
        String description = scanner.nextLine();
        System.out.println("Priorytet (wyższa liczba = wyższy priorytet):");
        int priority = scanner.nextInt();
        scanner.nextLine();
        NewTaskDto newTaskDto = new NewTaskDto(title, description, priority);
        Long newTaskId = taskService.createTask(newTaskDto);
        System.out.println("Zadanie zapisane z identyfikatorem " + newTaskId);
    }

    private void printTask() {
        long taskId = getIdFromUser();
        Optional<String> taskInfo = taskService.getTaskInfo(taskId);
        taskInfo.ifPresentOrElse(
                System.out::println,
                () -> System.out.println("Brak wpisu o takim id")
        );
    }

    private void endTask() {
        Long taskId = getIdFromUser();

        try {
            TaskDurationDto task = taskService.endTask(taskId);

            LocalDateTime startTime = task.getStartTime();
            LocalDateTime completeTime = task.getCompleteTime();
            completeTime = completeTime.plusHours(1);
            completeTime = completeTime.plusMinutes(3);
            Duration executionTime = Duration.between(startTime, completeTime);

            long seconds = executionTime.toSecondsPart();
            long minutes = executionTime.toMinutesPart();
            long hours = executionTime.toHoursPart();

            System.out.println("Czas rozpoczęcia zadania: " + startTime);
            System.out.println("Czas zakończenia zadania: " + completeTime);
            System.out.printf("Czas wykonania zadania: %02d:%02d:%02d%n", hours, minutes, seconds);

        } catch (TaskAlreadyCompletedException e) {
            System.out.println("Zadanie zostało już zakończone.");
        } catch (TaskNotStartedException e) {
            System.out.println("Zadanie nie zostało jeszcze rozpoczęte.");
        }
    }

    private long getIdFromUser() {
        System.out.println("Podaj identyfikator zadania:");
        long taskId = scanner.nextLong();
        scanner.nextLine();
        return taskId;
    }

    private void exit() {
        System.out.println("Koniec programu!");
    }

    private enum Option {

        ADD(1, "Dodaj nowe zadanie"),
        PRINT_SINGLE(2, "Wyświetl zadanie"),
        PRINT_NOT_STARTED(3, "Wyświetl nierozpoczęte zadania"),
        PRINT_FINISHED(4, "Wyświetl zakończone zadania"),
        START_TASK(5, "Rozpocznij zadanie"),
        END_TASK(6, "Zakończ zadanie"),
        EXIT(7, "Koniec programu");

        private final int number;
        private final String name;

        Option(int number, String name) {
            this.number = number;
            this.name = name;
        }

        static Option fromInt(int option) {
            return values()[option - 1];
        }

        @Override
        public String toString() {
            return number + " - " + name;
        }
    }
}
