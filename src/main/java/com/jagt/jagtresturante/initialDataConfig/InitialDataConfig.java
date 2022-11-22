package com.jagt.jagtresturante.initialDataConfig;

import com.jagt.jagtresturante.menu.Menu;
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
            Menu menu = new Menu("Pasta Carbonara","Main Course", "Pasta", 10);
            Menu menu1 = new Menu("Classic lasagne", "Main Course","Pasta", 12);
            menuRepository.saveAll(List.of(menu, menu1));
        };
    }
}
