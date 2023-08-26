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

    public PizzaEntity get(int id) {
        return this.pizzaRepository.findById(id).orElse(null);
    }
}
