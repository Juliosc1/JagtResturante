package com.jagt.jagtresturante.repository;

import com.jagt.jagtresturante.model.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuRepository extends JpaRepository<Menu, Long> {
}
