package it.pizzeria.la_mia_pizzeria.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import it.pizzeria.la_mia_pizzeria.model.Tavolo;
import it.pizzeria.la_mia_pizzeria.repository.TavoloRepository;

@Service
public class TavoloServiceImpl implements TavoloService {

    private final TavoloRepository tavoloRepository;

    public TavoloServiceImpl(TavoloRepository tavoloRepository) {
        this.tavoloRepository = tavoloRepository;
    }

    @Override
    public List<Tavolo> findAll() {
        return tavoloRepository.findAll();
    }

    @Override
    public Optional<Tavolo> findById(Long id) {
        return tavoloRepository.findById(id);
    }

    @Override
    public Tavolo save(Tavolo tavolo) {
        return tavoloRepository.save(tavolo);
    }

    @Override
    public void deleteById(Long id) {
        tavoloRepository.deleteById(id);
    }

}
