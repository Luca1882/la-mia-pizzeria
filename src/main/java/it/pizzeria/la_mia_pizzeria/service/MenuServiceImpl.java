package it.pizzeria.la_mia_pizzeria.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import it.pizzeria.la_mia_pizzeria.model.Menu;
import it.pizzeria.la_mia_pizzeria.repository.MenuRepository;

@Service
public class MenuServiceImpl implements MenuService {

    private final MenuRepository menuRepository;

    // Iniezione tramite costruttore
    public MenuServiceImpl(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    @Override
    public List<Menu> findAll() {
        return menuRepository.findAll();
    }

    @Override
    public Optional<Menu> findById(Long id) {
        return menuRepository.findById(id);
    }

    @Override
    public Menu save(Menu menu) {
        return menuRepository.save(menu);
    }

    @Override
    public void deleteById(Long id) {
        menuRepository.deleteById(id);
    }

}
