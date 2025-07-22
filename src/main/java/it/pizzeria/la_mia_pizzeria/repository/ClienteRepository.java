package it.pizzeria.la_mia_pizzeria.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import it.pizzeria.la_mia_pizzeria.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    //Cercare per nome (case insensitive)
    List<Cliente> findByNomeContainingIgnoreCase(String nome);

    //Cercare per cognome
    List<Cliente> findByCognomeContainingIgnoreCase(String cognome);

    //Cercare per mail
    List<Cliente> findByEmail(String email);

    //Cercare per telefono
    List<Cliente> findByTelefono(String telefono);

}
