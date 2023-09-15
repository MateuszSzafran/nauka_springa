package pl.mszafran.dto_standard;

import org.springframework.stereotype.Service;

@Service
class VatCalculatorService {

    private double getVatAmount(double nettoPrice, String category) {
        double vatRate = switch (category) {
            case "food" -> 0.05;
            case "services" -> 0.23;
            default -> 0.15;
        };
        return nettoPrice * vatRate;
    }

    VatDto getPriceInfo(double nettoPrice, String category) {
        double vatAmount = getVatAmount(nettoPrice, category);
        double grossPrice = nettoPrice + vatAmount;
        return new VatDto(nettoPrice, grossPrice, vatAmount);
    }
}
