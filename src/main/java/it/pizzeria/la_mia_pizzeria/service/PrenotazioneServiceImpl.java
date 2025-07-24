package it.pizzeria.la_mia_pizzeria.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import it.pizzeria.la_mia_pizzeria.model.Prenotazione;
import it.pizzeria.la_mia_pizzeria.repository.PrenotazioneRepository;

@Service
public class PrenotazioneServiceImpl implements PrenotazioneService{

    private final PrenotazioneRepository prenotazioneRepository;

    public PrenotazioneServiceImpl(PrenotazioneRepository prenotazioneRepository) {
        this.prenotazioneRepository = prenotazioneRepository;
    }

    @Override
    public List<Prenotazione> findAll() {
        return prenotazioneRepository.findAll();
    }

    @Override
    public Optional<Prenotazione> findById(Long id) {
        return prenotazioneRepository.findById(id);
    }

    @Override
    public Prenotazione save(Prenotazione prenotazione) {
        return prenotazioneRepository.save(prenotazione);
    }

    @Override
    public void deleteById(Long id) {
        prenotazioneRepository.deleteById(id);
    }
} 
