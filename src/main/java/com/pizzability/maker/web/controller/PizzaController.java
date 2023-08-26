package com.pizzability.maker.web.controller;

import com.pizzability.maker.persistence.entity.PizzaEntity;
import com.pizzability.maker.service.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pizzas")
public class PizzaController {
    private final PizzaService pizzaService;

    @Autowired
    public PizzaController(PizzaService pizzaService) {
        this.pizzaService = pizzaService;
    }

    @GetMapping
    public ResponseEntity<List<PizzaEntity>> getAll() {
        return ResponseEntity.ok(this.pizzaService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PizzaEntity> get(@PathVariable int id) {
        return this.pizzaService.exists(id)
                ? ResponseEntity.ok(this.pizzaService.get(id))
                : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<PizzaEntity> add(@RequestBody PizzaEntity pizza) {
        return (pizza.getIdPizza() == null || !this.pizzaService.exists(pizza.getIdPizza()))
                ? ResponseEntity.ok(this.pizzaService.save(pizza))
                : ResponseEntity.badRequest().build();
    }

    @PutMapping
    public ResponseEntity<PizzaEntity> update(@RequestBody PizzaEntity pizza) {
        return (pizza.getIdPizza() != null && this.pizzaService.exists(pizza.getIdPizza()))
                ? ResponseEntity.ok(this.pizzaService.save(pizza))
                : ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        ResponseEntity<Void> responseEntity = ResponseEntity.notFound().build();
        if (this.pizzaService.exists(id)) {
            this.pizzaService.delete(id);
            responseEntity = ResponseEntity.ok().build();
        }
        return responseEntity;
    }
}
