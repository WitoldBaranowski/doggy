package com.doggy.DatabaseCon;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class UserConfig {
    @Bean
    CommandLineRunner commandLineRunner(com.doggy.DatabaseCon.UserRepository repository){
        return args -> {
            com.doggy.DatabaseCon.User adam = new com.doggy.DatabaseCon.User("Adam","1234","kasia.pasik@gmail.pl");
            com.doggy.DatabaseCon.User michal = new com.doggy.DatabaseCon.User("Arkadiusz","1234","Arek.dobry.kumpel@gmail.pl");
            com.doggy.DatabaseCon.User error = new com.doggy.DatabaseCon.User("Krzysiek","1234","krzysiek@gmail.com");
            repository.saveAll(
                    List.of(error,adam, michal)
            );
        };

    }
}
