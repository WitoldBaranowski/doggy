package com.doggy.Comments;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ComsConfig {
    @Bean
    CommandLineRunner commandLineRunner1(com.doggy.Comments.ComRepository repository){
        return args -> {
/*            com.doggy.Comments.Comments com1 = new Comments("https://images.dog.ceo/breeds/bulldog-english/murphy.jpg","duduś","pisesie");
            Comments com2 = new Comments("https://images.dog.ceo/breeds/terrier-irish/n02093991_2765.jpg","michal","pisesie2");
            Comments com3 = new Comments("https://images.dog.ceo/breeds/waterdog-spanish/20180723_185544.jpg","michal3","pisesie3");
            repository.saveAll(
                    List.of(com1,com2,com3)
            );*/
        };

    }
}
