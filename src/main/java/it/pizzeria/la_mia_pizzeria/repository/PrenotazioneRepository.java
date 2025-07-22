package it.pizzeria.la_mia_pizzeria.repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import it.pizzeria.la_mia_pizzeria.model.Prenotazione;

public interface PrenotazioneRepository extends JpaRepository<Prenotazione, Long>{

    //Ricerca prenotazione per una data specifica
    List<Prenotazione> findByData(LocalDate data);

    //Ricerca prenotazione per data e ora esatta
    List<Prenotazione> findByDataAndOra(LocalDate data, LocalTime ora);

    //Ricerca prenotazione per causale (Pranzo/Cena)
    List<Prenotazione> findByCausaleIgnoreCase(String causale);

    //Ricerca prenotazione per Id_Cliente
    List<Prenotazione> findByClienteId(Long clienteId);

    //Ricerca per interallo di date(Inizio e Fine)
    List<Prenotazione> findByDataBetween(LocalDate inizio, LocalDate fine);
}
