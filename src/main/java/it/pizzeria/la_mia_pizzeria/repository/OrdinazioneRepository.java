package it.pizzeria.la_mia_pizzeria.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import it.pizzeria.la_mia_pizzeria.model.Ordinazione;

public interface OrdinazioneRepository extends JpaRepository<Ordinazione, Long> {

    //Ricerca tutte le ordinazioni relative ad una singola prenotazione
    List<Ordinazione> findByPrenotazioneId(Long prenotazioneId);

    //Ricerca tutte le ordinazioni relative ad un singolo cliente tramite prenotazione
    List<Ordinazione> findByPrenotazioneClienteId(Long clienteId);

    //Ricerca tutte le ordinazioni per piatto
    List<Ordinazione> findByPiattoNomeContainingIgnoreCase(String nome);
} 
