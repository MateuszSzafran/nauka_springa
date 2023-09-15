package pl.mszafran.thymeleaf_control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
class MainController {

    TextStatsService statsService;

    public MainController(TextStatsService statsService) {
        this.statsService = statsService;
    }

    @GetMapping("/")
    String mainPage() {
        return "index";
    }

    @PostMapping("/stats")
    String getStats(Model model, @RequestParam(required = false) String data,
                    @RequestParam(required = false) boolean textLength,
                    @RequestParam(required = false) boolean wordsNumber,
                    @RequestParam(required = false) boolean palindrome,
                    @RequestParam(required = false) boolean popularWord
    ) {
        if (data == null || data.isEmpty()) {
            return "no-text";
        }
        TextDto textDto = statsService.getTextInfo(data, textLength, wordsNumber, palindrome, popularWord);
        model.addAttribute("text", textDto);
        return "stats";
    }
}
