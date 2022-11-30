package com.jagt.jagtresturante.controller;

import com.jagt.jagtresturante.exception.ApiRequestException;
import com.jagt.jagtresturante.model.Menu;

import com.jagt.jagtresturante.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/menu")
public class MenuController {

    private final MenuRepository menuRepository;
    @Autowired
    public MenuController(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    @GetMapping
    public List<Menu> getAllMenus() {
        return menuRepository.findAll();
    }

    @PostMapping
    public Menu createMenu(@RequestBody Menu menu) {
        return menuRepository.save(menu);
    }

    @GetMapping("{id}")
    public ResponseEntity<Menu> getMenuById(@PathVariable long id)
        throws ApiRequestException {
        Menu menu = menuRepository.findById(id)
                .orElseThrow(() -> new ApiRequestException("Haha Menu dose not exist with id: " + id));
        return new ResponseEntity<>(menu, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Menu> updateMenu(@PathVariable long id,@RequestBody Menu menuDetails) {
    Menu updateMenu = menuRepository.findById(id)
            .orElseThrow(() -> new ApiRequestException("Menu does not exist with id: " + id));
    updateMenu.setName(menuDetails.getName());
    updateMenu.setCategory(menuDetails.getCategory());
    updateMenu.setTypeOfDishes(menuDetails.getTypeOfDishes());
    updateMenu.setPriceInEuro(menuDetails.getPriceInEuro());

    menuRepository.save(updateMenu);
    return ResponseEntity.ok(updateMenu);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Menu> deleteMenu(@PathVariable long id) {
        Menu menu = menuRepository.findById(id)
                .orElseThrow(() -> new ApiRequestException("Haha could not delete. Menu doesn't exist with id: " + id));
        menuRepository.delete(menu);
        return new ResponseEntity<>(menu, HttpStatus.NO_CONTENT);
    }
}