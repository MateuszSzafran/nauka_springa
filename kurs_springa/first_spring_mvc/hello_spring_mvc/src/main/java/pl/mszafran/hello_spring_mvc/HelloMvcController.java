package pl.mszafran.hello_spring_mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Controller
public class HelloMvcController {

    @RequestMapping("/current-time")
    @ResponseBody
    private String printCurrentTime(){
        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
        return dateTime.format(formatter);
    }

    @RequestMapping("/current-year")
    @ResponseBody
    private int printCurrentYear(){
        return LocalDateTime.now().getYear();
    }
}
