package org.example.app;

import lombok.RequiredArgsConstructor;
import org.example.app.model.Category;
import org.example.app.model.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class MockitoTestApplication {
    @Autowired
    private  CategoryRepo categoryRepo;

    @Bean
    @Profile("dev")
    public ApplicationRunner applicationRunner() {
        return args -> {
            var  categories = Stream.of(
                    new Category(null , "Laptop" , "good and test" , 4000.00),
                    new Category(null , "Phone" , "good and test" , 5000.00)
            ).collect(Collectors.toList());
            categoryRepo.saveAll(categories);
        };

    }
    public static void main(String[] args) {
        SpringApplication.run(MockitoTestApplication.class, args);
    }

}
