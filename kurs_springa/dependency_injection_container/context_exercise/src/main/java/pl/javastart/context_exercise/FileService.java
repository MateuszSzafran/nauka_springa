package pl.javastart.context_exercise;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import pl.javastart.context_exercise.code.Code;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

@Service
class FileService {
    private final LinguConfig linguConfig;
    private final Code codeType;

    FileService(LinguConfig linguconfig, Code codeType) {
        this.linguConfig = linguconfig;
        this.codeType = codeType;
    }

    List<Entry> readAllFile() throws IOException {
        List<String> allLines = Files.readAllLines(Paths.get(linguConfig.getFileName()));
        return allLines.stream()
                .map(this.codeType::decode)
                .map(CsvEntryConverter::parse)
                .collect(Collectors.toList());
    }

    void saveEntries(List<Entry> entries) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(linguConfig.getFileName()));
        for (Entry entry : entries) {
            String line = codeType.code(entry.toString());
            writer.write(line);
            writer.newLine();
        }
        writer.close();
    }

    private static class CsvEntryConverter {
        static Entry parse(String text) {
            String[] split = text.split(";");
            return new Entry(split[0], split[1]);
        }
    }
}
