package pl.javastart.context_exercise.code;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("dev")
class NoCode implements Code{
    @Override
    public String code(String entry) {
        return entry;
    }

    @Override
    public String decode(String line) {
        return line;
    }
}
