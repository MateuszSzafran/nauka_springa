package pl.javastart.context_exercise.formatter;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("noTextFormat")
class OriginalFormatter implements TextFormatter{
    @Override
    public String formatText(String text) {
        return text;
    }
}
