package pl.mszafran.fragments;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
class ProductController {
    private final ProductRepository repository;

    public ProductController(ProductRepository repository){
        this.repository = repository;
    }

    @GetMapping("/")
    String home(Model model){
        model.addAttribute("products", repository.findAll());
        return "index";
    }

    @GetMapping("/product")
    String getProduct(@RequestParam Long id, Model model){
        Optional<Product> productOptional = repository.findById(id);
        productOptional.ifPresent((x)->model.addAttribute("product", x));
        return "product";
    }

}
