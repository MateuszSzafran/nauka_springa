package pl.javastart.profiles_development_environmental;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ShopApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(ShopApplication.class, args);
        ProductRepository repo = context.getBean(ProductRepository.class);
        repo.findAll().forEach(System.out::println);
    }

}
