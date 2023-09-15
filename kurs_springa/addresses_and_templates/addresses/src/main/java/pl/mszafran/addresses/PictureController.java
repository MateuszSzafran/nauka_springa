package pl.mszafran.addresses;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.NoSuchElementException;
import java.util.Optional;

@Controller
class PictureController {

    PictureRepository repository;

    public PictureController(PictureRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/pic")
    String showPicture(Model model, @RequestParam String id){
        Picture picture = repository.findById(id).orElseThrow(() -> new NoSuchElementException("Brak takiego obrazka"));
        model.addAttribute("picture", picture);
        return "picture";
    }
}
