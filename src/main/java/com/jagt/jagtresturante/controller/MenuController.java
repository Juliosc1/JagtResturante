package com.jagt.jagtresturante.controller;

import com.jagt.jagtresturante.exception.ApiRequestException;
import com.jagt.jagtresturante.model.Menu;

import com.jagt.jagtresturante.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
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
        return ResponseEntity.ok().body(menu);
    }

    /*@GetMapping("{id}")
    public ResponseEntity<Menu> getEmployeeById(@PathVariable long id) throws ApiRequestException {
        try {
            Optional<Menu> byId = menuRepository.findById(id);
            if (byId == null) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            throw new ApiRequestException("Employee not exist with id:" + id);
            //return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }*/

    @PutMapping("{id}")
    public ResponseEntity<Menu> updateMenu(@PathVariable long id,@RequestBody Menu menuDetails) {
    Menu updateMenu = menuRepository.findById(id)
            .orElseThrow();
    updateMenu.setName(menuDetails.getName());
    updateMenu.setCategory(menuDetails.getCategory());
    updateMenu.setTypeOfDishes(menuDetails.getTypeOfDishes());
    updateMenu.setPrice(menuDetails.getPrice());

    menuRepository.save(updateMenu);
    return ResponseEntity.ok(updateMenu);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteMenu(@PathVariable long id) {
        Menu menu = menuRepository.findById(id)
                .orElseThrow();
        menuRepository.delete(menu);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}