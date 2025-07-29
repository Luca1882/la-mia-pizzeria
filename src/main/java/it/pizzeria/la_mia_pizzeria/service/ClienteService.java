package it.pizzeria.la_mia_pizzeria.service;

import java.util.List;
import java.util.Optional;

import it.pizzeria.la_mia_pizzeria.model.Cliente;

public interface ClienteService {
    Cliente save(Cliente cliente);
    List<Cliente> findAll();
    Optional<Cliente> findById(Long id);    
}
