package it.pizzeria.la_mia_pizzeria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.pizzeria.la_mia_pizzeria.model.Tavolo;

public interface TavoloRepository extends JpaRepository<Tavolo, Long> {
	//Attualmente lasciamo la ricerca classica, in futuro possiamo cercare per numero di posti
}
