package pl.mszafran.thymeleaf_with_text_lesson;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
class HomeController {

    @GetMapping("/")
    String home(Model model){
        model.addAttribute("firstName", "Mateusz");
        model.addAttribute("lastName", "Szafran");
        return "index";
    }
}
