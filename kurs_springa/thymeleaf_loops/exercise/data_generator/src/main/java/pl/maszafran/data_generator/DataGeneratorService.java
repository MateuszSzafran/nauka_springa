package pl.maszafran.data_generator;

import com.github.javafaker.Faker;
import org.springframework.stereotype.Service;

import java.io.PushbackInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Service
class DataGeneratorService {
    public List<LanguageCollection> getLanguages() {
        return Arrays.stream(LanguageCollection.values())
                .collect(Collectors.toList());
    }

    public List<Data> getData(Integer dataNumber,
                              String language,
                              Boolean firstname,
                              Boolean lastname,
                              Boolean university,
                              Boolean country
    ) {

        Faker faker = new Faker(new Locale(language));
        List<Data> result = new ArrayList<>();

        for (int i = 0; i < dataNumber; i++) {
            Data row = new Data();
            if (firstname) {
                row.setFirstname(faker.name().firstName());
            }
            if (lastname) {
                row.setLastname(faker.name().lastName());
            }
            if (university) {
                row.setUniversity(faker.university().name());
            }
            if (country) {
                row.setCountry(faker.country().name());
            }
            result.add(row);
        }
        return result;
    }

    public List<String> getHeadline(Boolean firstname, Boolean lastname, Boolean university, Boolean country) {
        ArrayList<String> result = new ArrayList<>();
        if (firstname) {
            result.add("Imię");
        }
        if (lastname) {
            result.add("Nazwisko");
        }
        if (university) {
            result.add("Uczelnia");
        }
        if (country) {
            result.add("Kraj pochodzenia");
        }
        return result;
    }
}
