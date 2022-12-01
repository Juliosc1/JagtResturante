package com.jagt.jagtresturante.initialDataConfig;

import com.jagt.jagtresturante.model.Menu;
import com.jagt.jagtresturante.repository.MenuRepository;
import com.jagt.jagtresturante.model.Recipe;
import com.jagt.jagtresturante.repository.RecipeRepository;

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
            Menu menu2 = new Menu("Crostini", "Appetizers", "Bread", 5);
            Menu menu3 = new Menu("Lemon Gelato", "Dessert", "Ice Cream", 7);
            Menu menu4 = new Menu("Pizza Ai Funghi", "Main Course", "Pizza", 13);
            menuRepository.saveAll(List.of(menu, menu1, menu2, menu3, menu4));
        };
    }
    @Bean
    CommandLineRunner commandLineRunner2(RecipeRepository recipeRepository) {
        return args -> {
            Recipe recipe = new Recipe("flour","two cups", "fork", 2);
            recipeRepository.saveAll(List.of(recipe));
        };

    }
}
