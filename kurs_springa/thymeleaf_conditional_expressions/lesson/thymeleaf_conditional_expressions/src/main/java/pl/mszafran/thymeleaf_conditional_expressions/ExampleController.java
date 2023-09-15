package pl.mszafran.thymeleaf_conditional_expressions;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
class ExampleController {
    Person person = new Person("Jan", "Kowalski", 17);

    @GetMapping("/")
    String getPersonData(Model model){
        model.addAttribute("person", person);
        model.addAttribute("language", "fr");
        return "example";
    }
}
