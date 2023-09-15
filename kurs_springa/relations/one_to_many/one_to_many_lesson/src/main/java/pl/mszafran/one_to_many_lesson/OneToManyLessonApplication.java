package pl.mszafran.one_to_many_lesson;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class OneToManyLessonApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(OneToManyLessonApplication.class, args);

        Client client = new Client("Jan", "Kowalski", "Wysoka 40, 12-345 Chałupkowo");
        ClientRepository clientRepository = context.getBean(ClientRepository.class);
        clientRepository.save(client);

        UserOrder order1 = new UserOrder("Szafa modułowa", "Szafa modułowa BigBox z drzwiami przesuwnymi, 160x240cm", 1900.0, client);
        UserOrder order2 = new UserOrder("Łóżko", "Łóżko 160x200 z podnoszonym stelażem i skrzynią", 3200.0, client);
        OrderRepository clientOrderRepository = context.getBean(OrderRepository.class);
        clientOrderRepository.save(order1);
        clientOrderRepository.save(order2);

        clientRepository.findById(1L).ifPresent(System.out::println);
    }

}
