package pl.javastart.context_exercise;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Scanner;

@Configuration
class LinguConfig {
    private final String fileName;
    private final int testWordsNumber;

    LinguConfig(@Value("${app.fileName}") String fileName, @Value("${app.testWordsNumber}") int testWordsNumber){
        this.fileName = fileName;
        this.testWordsNumber = testWordsNumber;
    }

    String getFileName() {
        return fileName;
    }

    int getTestWordsNumber() {
        return testWordsNumber;
    }

    @Bean
    Scanner scanner(){
        return new Scanner(System.in);
    }


}
