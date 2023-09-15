package pl.mszafran.one_to_one_lesson;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Optional;

@SpringBootApplication
public class OneToOneLessonApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(OneToOneLessonApplication.class, args);
        UserDetails userDetails = new UserDetails("Jan", "Kowalski", "Wrocław, 50-503, ul. Legnicka 32/16");
        UserDetailsRepository userDetailsRepo = context.getBean(UserDetailsRepository.class);
        userDetailsRepo.save(userDetails);

        UserRepository userRepository = context.getBean(UserRepository.class);
        User user = new User("johnkowal", "strongpassword1", "johnkowal@example.com", userDetails);
        userRepository.save(user);

        Optional<User> firstUser = userRepository.findById(1L);
        System.out.println("Informacje o pierwszym użytkowniku:");
        firstUser.ifPresent(System.out::println);
        System.out.println("Szczegóły pierwszego użytkownika:");
        firstUser.map(User::getUserDetails).ifPresent(System.out::println);

        System.out.println("Szczegóły pierwszego użytkownika pobrane z bazy:");
        Optional<UserDetails> firstDetails = userDetailsRepo.findById(1L);
        firstDetails.ifPresent(System.out::println);
        System.out.println("Użytkownik powiązany ze szczegółami:");
        firstDetails.map(UserDetails::getUser).ifPresent(System.out::println);
    }


}
