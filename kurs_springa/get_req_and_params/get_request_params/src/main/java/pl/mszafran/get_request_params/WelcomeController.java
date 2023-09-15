package pl.mszafran.get_request_params;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WelcomeController {

    @GetMapping("/welcome")
    @ResponseBody
    private String welcome(@RequestHeader(name = "User-Agent") String browser, @RequestParam(required = false, defaultValue = "stranger")  String name){
        System.out.println(browser);
        return "Hello " +name;
    }
}
