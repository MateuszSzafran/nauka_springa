package pl.mszafran.dto_standard;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

@Controller
class VatController {
    private final VatCalculatorService vatService;

    VatController(VatCalculatorService vatService) {
        this.vatService = vatService;
    }

    @PostMapping("/calculate")
    String calculate(@RequestParam double nettoPrice, @RequestParam String category, Model model) {
        VatDto vat = vatService.getPriceInfo(nettoPrice, category);
        model.addAttribute("vat", vat);
        return "result";
    }
}
