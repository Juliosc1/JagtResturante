package com.jagt.jagtresturante.repository;

import com.jagt.jagtresturante.menu.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuRepository extends JpaRepository<Menu, Long> {
}
