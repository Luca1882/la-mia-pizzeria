package it.pizzeria.la_mia_pizzeria.controller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import it.pizzeria.la_mia_pizzeria.model.Prenotazione;
import it.pizzeria.la_mia_pizzeria.service.ClienteService;
import it.pizzeria.la_mia_pizzeria.service.MenuService;
import it.pizzeria.la_mia_pizzeria.service.PrenotazioneService;
import it.pizzeria.la_mia_pizzeria.service.TavoloService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/prenotazioni")
public class PrenotazioneController {

    private final PrenotazioneService prenotazioneService;
    private final TavoloService tavoloService;
    private final MenuService menuService;
    private final ClienteService clienteService;

    public PrenotazioneController(PrenotazioneService prenotazioneService,
            TavoloService tavoloService,
            MenuService menuService,
            ClienteService clienteService) {
        this.prenotazioneService = prenotazioneService;
        this.tavoloService = tavoloService;
        this.menuService = menuService;
        this.clienteService = clienteService;
    }

    // Visualizza lista prenotazioni
    @GetMapping
    public String listaPrenotazioni(@RequestParam (required = false) LocalDate data,
                                    @RequestParam (required = false) LocalTime ora,
                                    @RequestParam (required = false) String causale,
                                    @RequestParam (required = false) Long clienteId,
                                    Model model) {
    List<Prenotazione> prenotazioni;
    
    boolean hasFiltri = data != null || ora != null || causale != null || clienteId != null;

    if (hasFiltri) {
        prenotazioni = prenotazioneService.cercaKeyword(data, ora, causale, clienteId);
    } else {
        prenotazioni = prenotazioneService.findAll();
    }
    model.addAttribute("prenotazioni", prenotazioni);
    model.addAttribute("data", data);
    model.addAttribute("ora", ora);
    model.addAttribute("causale", causale);
    model.addAttribute("clienteId", clienteId);

        return "prenotazioni/lista";
    }

    // Creazione di una nuova prenotazione
    @GetMapping("/nuova")
    public String nuovaPrenotazioneForm(Model model) {
        model.addAttribute("prenotazione", new Prenotazione());
        model.addAttribute("tavoli", tavoloService.findAll());
        model.addAttribute("menu", menuService.findAll());
        model.addAttribute("clienti", clienteService.findAll());
        return "prenotazioni/form";
    }

    // Salva prenotazione
    @PostMapping("/salva")
    public String salvaPrenotazione(@Valid @ModelAttribute("prenotazione") Prenotazione prenotazione,
            BindingResult bindingResult,
            Model model,
            RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("tavoli", tavoloService.findAll());
            model.addAttribute("menu", menuService.findAll());
            model.addAttribute("clienti", clienteService.findAll());
            return "prenotazioni/form";
        }
        prenotazioneService.save(prenotazione);
        redirectAttributes.addFlashAttribute("successMessage", "Prenotazione salvata con successo!");
        return "redirect:/prenotazioni";
    }

    // Modifica della prenotazione
    @GetMapping("/edit/{id}")
    public String modificaPrenotzione(@PathVariable Long id, Model model) {
        Prenotazione prenotazione = prenotazioneService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Prenotazione non trovata con id: " + id));

        model.addAttribute("tavoli", tavoloService.findAll());
        model.addAttribute("prenotazione", prenotazione);
        model.addAttribute("menu", menuService.findAll());

        return "prenotazioni/form";
    }

    // Salva la modifica della prenotazione
    @PostMapping("/update/{id}")
    public String aggiornaPrenotazione(@PathVariable Long id,
            @Valid @ModelAttribute Prenotazione prenotazione,
            BindingResult bindingResult,
            Model model,
            RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("tavoli", tavoloService.findAll());
            model.addAttribute("menu", menuService.findAll());
            return "prenotazioni/form";
        }

        prenotazione.setId(id);
        prenotazioneService.save(prenotazione);
        redirectAttributes.addFlashAttribute("successMessage", "Prenotazione aggiornatta con successo!");
        return "redirect:/prenotazioni";
    }

    // Eliminazione della prenotazione
    @GetMapping("/delete/{id}")
    public String deletePrenotazione(@PathVariable Long id) {
        prenotazioneService.deleteById(id);
        return "redirect:/prenotazioni";
    }

}
