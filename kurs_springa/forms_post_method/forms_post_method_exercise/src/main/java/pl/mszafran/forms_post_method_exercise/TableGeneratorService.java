package pl.mszafran.forms_post_method_exercise;

import com.github.freva.asciitable.AsciiTable;

class TableGeneratorService {
    public static final String DATA_SEPARATOR = ";";
    static String generate(String[] header, String[][] data){

        return AsciiTable.getTable(header, data);
    }
}
