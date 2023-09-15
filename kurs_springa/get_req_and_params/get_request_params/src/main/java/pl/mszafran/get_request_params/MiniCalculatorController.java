package pl.mszafran.get_request_params;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MiniCalculatorController {

    @GetMapping(path = {"calc", "calculate", "licz"})
    @ResponseBody
    private String calc(@RequestParam (name = "pierwsza") Double a, @RequestParam(name="druga") Double b){

        Double result = a + b;

        return String.format("%.2f + %.2f = %.2f", a, b, result);
    }
}
