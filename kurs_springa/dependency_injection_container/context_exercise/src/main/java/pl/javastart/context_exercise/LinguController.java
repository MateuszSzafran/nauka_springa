package pl.javastart.context_exercise;

import org.springframework.stereotype.Controller;

import java.io.IOException;
import java.util.Scanner;
import java.util.Set;

@Controller
class LinguController {
    private final LinguConfig linguConfig;
    private final EntryRepository entryRepository;
    private final FileService fileService;
    private final Scanner scanner;
    private final TextPrinter textPrinter;


    LinguController(EntryRepository entryRepository, FileService fileService,
                    Scanner scanner, TextPrinter textPrinter, LinguConfig linguConfig){
        this.entryRepository = entryRepository;
        this.fileService = fileService;
        this.scanner = scanner;
        this.textPrinter = textPrinter;
        this.linguConfig = linguConfig;
    }

    void mainLoop() {
        textPrinter.printText("Welcome in LinguApp");
        Option option = null;
        do {
            printMenu();
            try {
                option = chooseOption();
                executeOption(option);
            } catch (IllegalArgumentException e) {
                textPrinter.printText(e.getMessage());
            }
        } while (option != Option.EXIT);
    }
    private Option chooseOption() {
        int option = scanner.nextInt();
        scanner.nextLine();
        return Option.fromInt(option);
    }

    private void executeOption(Option option) {
        switch (option) {
            case ADD_ENTRY -> addEntry();
            case START_TEST -> startTest();
            case EXIT -> close();
        }
    }

    private void startTest() {
        if(entryRepository.isEmpty()) {
            textPrinter.printText("Add at least one record to the database.");
            return;
        }
        final int testSize = Math.min(entryRepository.size(), linguConfig.getTestWordsNumber());
        Set<Entry> randomEntries = entryRepository.getRandomEntries(testSize);
        int score = 0;
        for (Entry entry : randomEntries) {
            textPrinter.printText(String.format("Give the translation for: \"%s\"", entry.getOriginal()));
            String translation = scanner.nextLine();
            if(entry.getTranslation().equalsIgnoreCase(translation)) {
                textPrinter.printText("Correct answer");
                score++;
            } else {
                textPrinter.printText("Wrong answer - " + entry.getTranslation());
            }
        }
        textPrinter.printText(String.format("Your score: %d/%d", score, testSize));
    }

    private void addEntry() {
        textPrinter.printText("Give the phrase in Polish:");
        String original = scanner.nextLine();
        textPrinter.printText("Give the phrase in English:");
        String translation = scanner.nextLine();
        Entry entry = new Entry(original, translation);
        entryRepository.add(entry);
    }

    private void close() {
        try {
            fileService.saveEntries(entryRepository.getAll());
            textPrinter.printText("The application status has been saved");
        } catch (IOException e) {
            textPrinter.printText("Changes have not been saved");
        }
        textPrinter.printText("Bye Bye!");
    }

    private void printMenu() {
        textPrinter.printText("Choose option:");
        for (Option option : Option.values()) {
            textPrinter.printText(option.toString());
        }
    }

    private static enum Option {
        ADD_ENTRY(1, "Add the text with the translation"),
        START_TEST(2, "Begin the test"),
        EXIT(3, "Exit");

        private final int optionNumber;
        private final String description;

        Option(int optionNumber, String description) {
            this.optionNumber = optionNumber;
            this.description = description;
        }

        static Option fromInt(int option) {
            if (option < 0 || option > values().length) {
                throw new IllegalArgumentException("An option with this number does not exist");
            }
            return values()[option - 1];
        }

        @Override
        public String toString() {
            return String.format("%d - %s", optionNumber, description);
        }
    }
}