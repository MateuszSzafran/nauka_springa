package pl.javastart.numbers;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
class NumbersGeneratorController {

    private final NumberService numberService;

    public NumbersGeneratorController(NumberService numberService) {
        this.numberService = numberService;
    }

    @GetMapping("/random")
    @ResponseBody
    String getRandomNumber(HttpServletRequest request,
                           @RequestParam(required = false, defaultValue = "0") int from,
                           @RequestParam(required = false, defaultValue = "1000") int to) {
        from = getFromBound(request, from, to);
        to = getToBound(request, from, to);
        if (from <= to) {
            Integer randomNumber = numberService.getRandomNumberFromRange(from, to);
            return String.format("Losowa liczba z przedziału [%d; %d]:%d", from, to, randomNumber);
        } else {
            return "Dolne ograniczenie musi być mniejsze, bądź równe górnemu ograniczeniu";
        }
    }

    @GetMapping("/even-numbers")
    @ResponseBody
    String getEvenNumbers(HttpServletRequest request,
                          @RequestParam(required = false, defaultValue = "0") int from,
                          @RequestParam(required = false, defaultValue = "1000") int to) {
        from = getFromBound(request, from, to);
        to = getToBound(request, from, to);
        if (from <= to) {
            List<Integer> evenNumbers = numberService.getEvenNumbersFromRange(from, to);
            return String.format("Liczby parzyste z przedziału [%d; %d]:%s", from, to, evenNumbers);
        } else {
            return "Dolne ograniczenie musi być mniejsze, bądź równe górnemu ograniczeniu";
        }
    }

    @GetMapping("/odd-numbers")
    @ResponseBody
    String getOddNumbers(HttpServletRequest request,
                         @RequestParam(required = false, defaultValue = "0") int from,
                         @RequestParam(required = false, defaultValue = "1000") int to) {
        from = getFromBound(request, from, to);
        to = getToBound(request, from, to);
        if (from <= to) {
            List<Integer> oddNumbers = numberService.getOddNumbersFromRange(from, to);
            return String.format("Liczby nieparzyste z przedziału [%d; %d]:%s", from, to, oddNumbers);
        } else {
            return "Dolne ograniczenie musi być mniejsze, bądź równe górnemu ograniczeniu";
        }
    }

    private int getFromBound(HttpServletRequest request, int from, int to) {
        if (request.getParameter("from") == null && request.getParameter("to") != null) {
            return to - 100;
        } else {
            return from;
        }
    }

    private int getToBound(HttpServletRequest request, int from, int to) {
        if (request.getParameter("from") != null && request.getParameter("to") == null) {
            return from + 100;
        } else {
            return to;
        }
    }
}
