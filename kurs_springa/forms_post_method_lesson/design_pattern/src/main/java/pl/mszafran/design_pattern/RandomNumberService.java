package pl.mszafran.design_pattern;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
class RandomNumberService {
    private final Random random = new Random();

    int generateRandomInRange(int low, int high) {
        int range = high - low + 1;
        int randomNumber = random.nextInt(range);
        return randomNumber + low;
    }
}
