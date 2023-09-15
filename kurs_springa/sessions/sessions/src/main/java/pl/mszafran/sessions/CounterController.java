package pl.mszafran.sessions;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
class CounterController {

    private final CounterSessionComponent counter;

    public CounterController(CounterSessionComponent counter){
        this.counter = counter;
    }

    @GetMapping("/")
    String count(){
        counter.count();
        return "index";
    }


}
