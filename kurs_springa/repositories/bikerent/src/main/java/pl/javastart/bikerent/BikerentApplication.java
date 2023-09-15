package pl.javastart.bikerent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;

@SpringBootApplication
public class BikerentApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(BikerentApplication.class, args);
        BikeService bikeService = context.getBean(BikeService.class);
        BikeDto bike1 = new BikeDto(1L, "BMX", "019111", 1.5, 9.99);
        BikeDto bike2 = new BikeDto(2L, "Kross", "010001", 1.9, 12.1);
        BikeDto bike3 = new BikeDto(3L, "Romet", "217111", 2, 11.6);
        BikeDto bike4 = new BikeDto(4L, "Trek", "099511", 1.3, 15.8);

        bikeService.add(bike1);
        bikeService.add(bike2);
        bikeService.add(bike3);
        bikeService.add(bike4);

        double payment = bikeService.rentForDay("217111", "ABC1234");
        System.out.println("Wypożyczono rower za kwotę " + payment);


        int borrowedBikes = bikeService.countBorrowedBikes();
        System.out.println("Liczba wypożyczonych rowerów: " + borrowedBikes);

        System.out.println("Dostępne rowery (cena rosnąco):");
        List<BikeDto> allAvailableBikes = bikeService.findAllAvailableBikes();
        allAvailableBikes.forEach(System.out::println);

    }

}
