
package hello;

import hello.model.Client;
import hello.model.Guide;
import hello.model.Trip;
import hello.repositories.ClientRepository;
import hello.repositories.GuideRepository;
import hello.repositories.TripRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

    @Bean
    public CommandLineRunner demo(ClientRepository repository, GuideRepository guideRepository,
                                  TripRepository tripRepository) {
        return (args) -> {
            // save a couple of customers
            Guide gienek = new Guide("JOlo", "OL");
            Trip tripToMaroko = new Trip(gienek, "Zalesie");
            Client clark = new Client("Jack", "Bauer");
            tripToMaroko.addClient(clark);
            guideRepository.save(gienek);
            tripRepository.save(tripToMaroko);

        };
    }
}