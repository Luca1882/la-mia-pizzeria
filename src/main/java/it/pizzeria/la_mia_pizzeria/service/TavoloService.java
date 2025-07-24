package it.pizzeria.la_mia_pizzeria.service;

import java.util.List;
import java.util.Optional;

import it.pizzeria.la_mia_pizzeria.model.Tavolo;

// Interfaccio per il servizio di gestione dei tavoli
public interface TavoloService {

    // Metodi di gesrione dei tavoli
    List<Tavolo> findAll();
    Optional<Tavolo> findById(Long id);
    Tavolo save(Tavolo tavolo);
    void deleteById(Long id);
}
