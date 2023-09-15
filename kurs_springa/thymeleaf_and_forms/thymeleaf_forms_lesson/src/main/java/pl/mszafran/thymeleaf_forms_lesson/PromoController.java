package pl.mszafran.thymeleaf_forms_lesson;

import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
class PromoController {

    private final PromotionRepository promotionRepository;

    public PromoController(PromotionRepository promotionRepository){
        this.promotionRepository = promotionRepository;
    }

    @GetMapping("/")
    String showPromotions(Model model){
        model.addAttribute("promotions", promotionRepository.findAll());
        return "list";
    }

    @GetMapping("/add")
    String addForm(Model model){
        model.addAttribute("promotion", new Promotion());
        return "add-form";
    }

    @PostMapping("/save")
    RedirectView savePromotion(Promotion promotion){
        promotionRepository.add(promotion);
        return new RedirectView("/",true, false);
    }
}
