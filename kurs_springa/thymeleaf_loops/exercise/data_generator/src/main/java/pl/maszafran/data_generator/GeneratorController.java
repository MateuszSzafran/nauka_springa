package pl.maszafran.data_generator;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
class GeneratorController {
    private final DataGeneratorService generatorService;

    public GeneratorController(DataGeneratorService generatorService) {
        this.generatorService = generatorService;
    }

    @GetMapping("/")
    String mainPage(Model model) {
        model.addAttribute("languages", generatorService.getLanguages());
        return "index";
    }

    @PostMapping("/generate-data")
    String generate(Model model,
                    @RequestParam Integer dataNumber,
                    @RequestParam String language,
                    @RequestParam(required = false, defaultValue = "false") Boolean firstname,
                    @RequestParam(required = false, defaultValue = "false") Boolean lastname,
                    @RequestParam(required = false, defaultValue = "false") Boolean university,
                    @RequestParam(required = false, defaultValue = "false") Boolean country
    ) {
        List<String> headline = generatorService.getHeadline(firstname, lastname, university, country);
        List<Data> data = generatorService.getData(dataNumber, language, firstname, lastname, university, country);
        model.addAttribute("headline", headline);
        model.addAttribute("data", data);
        return "data";
    }
}
