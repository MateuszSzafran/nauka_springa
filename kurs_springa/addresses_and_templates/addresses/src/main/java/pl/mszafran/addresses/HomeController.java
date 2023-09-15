package pl.mszafran.addresses;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
class HomeController {
    private final PictureRepository repository;

    public HomeController(PictureRepository repository){
        this.repository = repository;
    }

    @GetMapping("/")
    String home(Model model){
        model.addAttribute("pictures", repository.findAll());
        return "index";
    }
}
