package pl.mszafran.design_pattern;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
class HomeController {
    private final RandomNumberService randomNumberService;

    public HomeController(RandomNumberService randomNumberService){
        this.randomNumberService = randomNumberService;
    }

    @GetMapping("/")
    String home(Model model, @RequestParam int from, @RequestParam int to){
        int randomNumber = randomNumberService.generateRandomInRange(from, to);
        model.addAttribute("from", from);
        model.addAttribute("to", to);
        model.addAttribute("number", randomNumber);
        return "index";
    }
}
