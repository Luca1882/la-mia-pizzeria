package it.pizzeria.la_mia_pizzeria.service;

import java.util.List;
import java.util.Optional;

import it.pizzeria.la_mia_pizzeria.model.Prenotazione;

// Interfaccia per il servizio di prenotazioni
public interface PrenotazioneService {

    // Metodi di gestione delle prenotazioni
    List<Prenotazione> findAll();
    Optional<Prenotazione> findById(Long id);
    Prenotazione save(Prenotazione prenotazione);
    void deleteById(Long id);
}
