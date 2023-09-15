package pl.javastart.context.producer;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

@Service
@Profile("file")
class FileMessageProducer implements MessageProducer{

    private final Scanner scanner;

    FileMessageProducer(Scanner scanner){
        this.scanner = scanner;
    }
    @Override
    public String getMessage() {
        Path path = getPath();
        try {
            return String.join(" ",Files.readAllLines(path));
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    private Path getPath(){
        System.out.println("Give the file name:");
        String userPath = scanner.nextLine();
        return Path.of(userPath);
    }
}
