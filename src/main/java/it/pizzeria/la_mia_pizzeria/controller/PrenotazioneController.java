package it.pizzeria.la_mia_pizzeria.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import it.pizzeria.la_mia_pizzeria.model.Prenotazione;
import it.pizzeria.la_mia_pizzeria.service.MenuService;
import it.pizzeria.la_mia_pizzeria.service.PrenotazioneService;
import it.pizzeria.la_mia_pizzeria.service.TavoloService;


@Controller
@RequestMapping("/prenotazioni")
public class PrenotazioneController {

    private final PrenotazioneService prenotazioneService;
    private final TavoloService tavoloService;
    private final MenuService menuService;

    // ✅ Iniezione tramite costruttore
    public PrenotazioneController(PrenotazioneService prenotazioneService,
                                  TavoloService tavoloService,
                                  MenuService menuService) {
        this.prenotazioneService = prenotazioneService;
        this.tavoloService = tavoloService;
        this.menuService = menuService;
    }

    //Visualizza lista prenotazioni
    @GetMapping
    public String listaPrenotazioni(Model model) {
        List<Prenotazione> prenotazioni = prenotazioneService.findAll();
        model.addAttribute("prenotazioni", prenotazioni);
        return "prenotazioni/lista";
    }

    //Creazione di una nuova prenotazione
    @GetMapping("/nuova")
    public String nuovaPrenotazione(Model model) {
        model.addAttribute("prenotazione", new Prenotazione());
        return "prenotazioni/form";
    }

    //Salva prenotazione
    @PostMapping("/salva")
    public String salvaPrenotazione(@ModelAttribute Prenotazione prenotazione) {
        prenotazioneService.save(prenotazione);
        return "redirect:/prenotaioni";
    }

    //Modifica della prenotazione
    @GetMapping("/edit/{id}")
    public String modificaPrenotzione(@PathVariable Long id, Model model) {
        Prenotazione prenotazione = prenotazioneService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Prenotazione non trovata con id: " + id));
                model.addAttribute("prenotazione", prenotazione);
        return "prenotazioni/form";
    }

    //Eliminazione della prenotazione
    @GetMapping("/delete/{id}")
    public String deletePrenotazione(@PathVariable Long id) {
        prenotazioneService.deleteById(id);
        return "redirect:/prenotazioni";
    }
    
}
