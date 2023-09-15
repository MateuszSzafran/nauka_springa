package pl.mszafran.code_formatter;

import com.google.googlejavaformat.java.FormatterException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
class FormatterController {
    private final FormatterService formatterService;

    FormatterController(FormatterService formatterService){
        this.formatterService = formatterService;
    }

    @GetMapping("/")
    String home(){
        return "index";
    }

    @PostMapping("/format-code")
    String format(@RequestParam String code, Model model){
        try {
            String formattedCode = formatterService.formatCode(code);
            model.addAttribute("sourceCode", code);
            model.addAttribute("formattedCode", formattedCode);
            return "format";
        } catch (FormatterException e) {
            return "no-java-code";
        }
    }
}
