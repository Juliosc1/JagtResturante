package com.jagt.jagtresturante.initialDataConfig;

import com.jagt.jagtresturante.model.Menu;
import com.jagt.jagtresturante.repository.MenuRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class InitialDataConfig {

    @Bean
    CommandLineRunner commandLineRunner(MenuRepository menuRepository) {
        return args -> {
            Menu dish1 = new Menu("Pasta Carbonara","Main Course", "Pasta", 10);
            Menu dish2 = new Menu("Classic lasagne", "Main Course","Pasta", 12);
            Menu dish3 = new Menu("Crostini", "Appetizers", "Bread", 5);
            Menu dish4 = new Menu("Lemon Gelato", "Dessert", "Ice Cream", 7);
            Menu dish5 = new Menu("Pizza Ai Funghi", "Main Course", "Pizza", 13);
            menuRepository.saveAll(List.of(dish1, dish2, dish3, dish4, dish5));
        };
    }
}
