package it.pizzeria.la_mia_pizzeria.service;

import java.util.List;
import java.util.Optional;

import it.pizzeria.la_mia_pizzeria.model.Menu;

// Interfaccia per il servizio di gestione del menu
public interface MenuService {

    // Metodi di gestione del menu
    List<Menu> findAll();
    Optional<Menu> findById(Long id);
    Menu save(Menu menu);
    void deleteById(Long id);
}
