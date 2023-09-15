package pl.mszafran.code_formatter;

import com.google.googlejavaformat.java.Formatter;
import com.google.googlejavaformat.java.FormatterException;
import org.springframework.stereotype.Service;

@Service
class FormatterService {

    String formatCode(String code) throws FormatterException {
        return new Formatter().formatSource(code);
    }
}
