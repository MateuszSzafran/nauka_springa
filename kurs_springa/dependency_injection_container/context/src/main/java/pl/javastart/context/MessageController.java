package pl.javastart.context;

import org.springframework.stereotype.Controller;


import java.util.Arrays;
import java.util.Optional;
import java.util.Scanner;

@Controller
class MessageController {
    private final Scanner scanner;
    private final MessagePrinter messagePrinter;

    public MessageController(Scanner scanner, MessagePrinter messagePrinter){
        this.scanner = scanner;
        this.messagePrinter = messagePrinter;
    }

    public void mainLoop(){
        Option option;
        do {
            option = chooseOption();
            executeOption(option);
        } while (option != Option.EXIT);
    }

    private void executeOption(Option option) {
        switch (option){
            case EXIT -> exit();
            case NEXT_MESSAGE -> printMessage();
        }
    }

    private void printMessage() {
        messagePrinter.printMessage();
    }

    private void exit() {
        scanner.close();
        System.out.println("See you next time!");
    }

    private Option chooseOption() {
        Optional<Option> option;
        do {
            printMenu();
            option = Option.fromInt(getIntFromUser());
        }while (option.isEmpty());
        return option.get();
    }

    private void printMenu(){
        System.out.println("Choose option:");
        Arrays.stream(Option.values())
                .map(Option::toString)
                .forEach(System.out::println);
    }

    private int getIntFromUser() {
        int number = scanner.nextInt();
        scanner.nextLine();
        return number;
    }

    private enum Option {
        EXIT (0, "Close the application"),
        NEXT_MESSAGE (1, "Give next message");

        private final int number;
        private final String description;

        Option(int number, String description){
            this.number = number;
            this.description = description;
        }

        static Optional<Option> fromInt(int choose){
            Option[] options = Option.values();
            if(choose >= 0 && choose < options.length){
                return Optional.of(options[choose]);
            }
            return Optional.empty();
        }

        @Override
        public String toString() {
            return number + " - " + description;
        }
    }
}
