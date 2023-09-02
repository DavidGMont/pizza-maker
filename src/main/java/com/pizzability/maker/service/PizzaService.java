package com.pizzability.maker.service;

import com.pizzability.maker.persistence.entity.PizzaEntity;
import com.pizzability.maker.persistence.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PizzaService {
    private final PizzaRepository pizzaRepository;

    @Autowired
    public PizzaService(PizzaRepository pizzaRepository) {
        this.pizzaRepository = pizzaRepository;
    }

    public List<PizzaEntity> getAll() {
        return this.pizzaRepository.findAll();
    }

    public List<PizzaEntity> getAvailable() {
        return this.pizzaRepository.findAllByAvailableTrueOrderByPrice();
    }

    public PizzaEntity getByName(String name) {
        return this.pizzaRepository.findAllByAvailableTrueAndNameIgnoreCase(name);
    }

    public List<PizzaEntity> getWith(String ingredient) {
        return this.pizzaRepository.findAllByAvailableTrueAndDescriptionContainingIgnoreCase(ingredient);
    }

    public List<PizzaEntity> getWithout(String ingredient) {
        return this.pizzaRepository.findAllByAvailableTrueAndDescriptionNotContainingIgnoreCase(ingredient);
    }

    public PizzaEntity get(int id) {
        return this.pizzaRepository.findById(id).orElse(null);
    }

    public PizzaEntity save(PizzaEntity pizza) {
        return this.pizzaRepository.save(pizza);
    }

    public void delete(int id) {
        this.pizzaRepository.deleteById(id);
    }

    public boolean exists(int id) {
        return this.pizzaRepository.existsById(id);
    }
}
