package it.pizzeria.la_mia_pizzeria.controller;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import it.pizzeria.la_mia_pizzeria.model.Cliente;
import it.pizzeria.la_mia_pizzeria.model.Menu;
import it.pizzeria.la_mia_pizzeria.model.Prenotazione;
import it.pizzeria.la_mia_pizzeria.model.Tavolo;
import it.pizzeria.la_mia_pizzeria.repository.ClienteRepository;
import it.pizzeria.la_mia_pizzeria.repository.MenuRepository;
import it.pizzeria.la_mia_pizzeria.repository.PrenotazioneRepository;
import it.pizzeria.la_mia_pizzeria.repository.TavoloRepository;

@Configuration
public class TestDatabase {

    @Bean
    CommandLineRunner runner(

        ClienteRepository clienteRepo,
        TavoloRepository tavoloRepo,
        MenuRepository menuRepo,
        PrenotazioneRepository prenotazioneRepo){

        return args -> {

            //Creazione di un cliente Test
            Cliente cliente = new Cliente();
            cliente.setNome("Luca");
            cliente.setCognome("Notarfranco");
            cliente.setEmail("luca.notarfranco@gmail.com");
            cliente.setTelefono("327-1510984");
            clienteRepo.save(cliente);

            //Creazione di un tavolo Test
            Tavolo tavolo = new Tavolo();
            tavolo.setNumeroPosti(4);
            tavolo.setPostiMassimi(4);
            tavoloRepo.save(tavolo);

            //Creazione di un menu Test
            Menu piatto = new Menu();
            piatto.setNome("Margherita");
            piatto.setDescrizione("Pizza con pomodoro e mozzarella");
            piatto.setPrezzo(7.50);
            menuRepo.save(piatto);

            //Creazione di una prenotazione Test
            Prenotazione prenotazione =new Prenotazione();
            prenotazione.setCliente(cliente);
            prenotazione.setTavolo(tavolo);
            prenotazione.setData(LocalDate.of(2025, 7, 26));
            prenotazione.setOra(LocalTime.of(20, 30));
            prenotazione.setNumeroPersone(4);
            prenotazione.setCausale("CENA");
            prenotazioneRepo.save(prenotazione);

            System.out.println("La prenotazione è stata creata con successo!");
        };
    }
}
