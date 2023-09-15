package pl.javastart.context_exercise.code;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("prod")
class CesarCode implements Code {
    @Override
    public String code(String entry) {
        char[] chars = entry.toCharArray();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            chars[i] += 3;
            result.append(chars[i]);
        }
        return result.toString();
    }

    @Override
    public String decode(String line) {
        char[] chars = line.toCharArray();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            chars[i] -= 3;
            result.append(chars[i]);
        }
        return result.toString();
    }
}
