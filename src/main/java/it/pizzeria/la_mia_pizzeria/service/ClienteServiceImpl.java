package it.pizzeria.la_mia_pizzeria.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import it.pizzeria.la_mia_pizzeria.model.Cliente;
import it.pizzeria.la_mia_pizzeria.repository.ClienteRepository;

@Service
public class ClienteServiceImpl implements ClienteService  {

    private final ClienteRepository clienteRepository;

    public ClienteServiceImpl(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }
    
    @Override
    public Cliente save(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    @Override
    public Optional<Cliente> findById(Long id) {
        return clienteRepository.findById(id);
    }
}
