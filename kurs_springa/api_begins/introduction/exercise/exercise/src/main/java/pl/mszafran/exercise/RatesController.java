package pl.mszafran.exercise;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.net.URI;
import java.util.Scanner;

@RestController
@RequestMapping(path="/api/rates")
class RatesController {

    @GetMapping("/gold")
    BigDecimal getArchiveGoldRate(){
//        http://api.nbp.pl/en.html
    }
}
