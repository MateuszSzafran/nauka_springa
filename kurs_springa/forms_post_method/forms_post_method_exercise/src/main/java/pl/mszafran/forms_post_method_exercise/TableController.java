package pl.mszafran.forms_post_method_exercise;

import com.github.freva.asciitable.AsciiTable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Array;
import java.util.List;
import java.util.stream.Stream;

@Controller
class TableController {
    @PostMapping("/generate-table")
    @ResponseBody
    String generateTable(@RequestParam String header, @RequestParam String content){
        String[] headers = header.split(TableGeneratorService.DATA_SEPARATOR);
        String[] dataRows = content.split("\r\n");
        String[][] data = new String[dataRows.length][];

        for (int rowNumber = 0; rowNumber < dataRows.length; rowNumber++) {
            data[rowNumber] = dataRows[rowNumber].split(TableGeneratorService.DATA_SEPARATOR);
        }

        String result = TableGeneratorService.generate(headers, data);
        return String.format("<pre>%s</pre>",result);

    }
}
