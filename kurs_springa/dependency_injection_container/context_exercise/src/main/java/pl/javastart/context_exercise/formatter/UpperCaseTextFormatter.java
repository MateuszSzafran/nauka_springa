package pl.javastart.context_exercise.formatter;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import pl.javastart.context_exercise.formatter.TextFormatter;

@Component
@Profile("upperCase")
class UpperCaseTextFormatter implements TextFormatter {
    @Override
    public String formatText(String text) {
        return text.toUpperCase();
    }
}
