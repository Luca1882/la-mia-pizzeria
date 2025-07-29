package it.pizzeria.la_mia_pizzeria.controller.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.pizzeria.la_mia_pizzeria.model.Cliente;
import it.pizzeria.la_mia_pizzeria.service.ClienteService;

@RestController
@RequestMapping("/api/clienti")

// Gestione delle info clienti tramite API REST
public class ClientiRestController {

    private final ClienteService clienteService;

    public ClientiRestController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping
    public ResponseEntity<Cliente> creaCliente(
            @RequestParam String nome,
            @RequestParam String cognome,
            @RequestParam String email,
            @RequestParam String telefono) {

        Cliente cliente = new Cliente();
        cliente.setNome(nome);
        cliente.setCognome(cognome);
        cliente.setEmail(email);
        cliente.setTelefono(telefono);

        Cliente nuovoCliente = clienteService.save(cliente);

        return ResponseEntity.ok(nuovoCliente);

    }
}
