package pl.javastart.context.producer;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
@Profile("console")
class ConsoleMessageProducer implements MessageProducer {

    private final Scanner scanner;

    ConsoleMessageProducer(Scanner scanner){
        this.scanner = scanner;
    }

    public String getMessage(){
        System.out.println("\nEnter text to print");
        return scanner.nextLine();
    }
}
