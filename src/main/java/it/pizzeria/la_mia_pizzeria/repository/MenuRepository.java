package it.pizzeria.la_mia_pizzeria.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import it.pizzeria.la_mia_pizzeria.model.Menu;

public interface MenuRepository extends JpaRepository<Menu, Long> {
    
    //Ricerca per nome (case insensitive)
    List<Menu> findByNomeContainingIgnoreCase(String nome);
}
