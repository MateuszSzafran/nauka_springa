package pl.javastart.context_exercise;

import org.springframework.stereotype.Service;
import pl.javastart.context_exercise.formatter.TextFormatter;

@Service
class TextPrinter {
    private final TextFormatter textFormatter;

    TextPrinter(TextFormatter textFormatter){
        this.textFormatter = textFormatter;
    }
    void printText(String text){
        System.out.println(textFormatter.formatText(text));
    }
}
