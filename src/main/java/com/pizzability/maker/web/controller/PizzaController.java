package com.pizzability.maker.web.controller;

import com.pizzability.maker.persistence.entity.PizzaEntity;
import com.pizzability.maker.service.PizzaService;
import com.pizzability.maker.service.dto.UpdatePizzaPriceDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
    public ResponseEntity<Page<PizzaEntity>> getAll(@RequestParam(defaultValue = "0") int page,
                                                    @RequestParam(defaultValue = "8") int elements) {
        return ResponseEntity.ok(this.pizzaService.getAll(page, elements));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PizzaEntity> get(@PathVariable int id) {
        return this.pizzaService.exists(id)
                ? ResponseEntity.ok(this.pizzaService.get(id))
                : ResponseEntity.notFound().build();
    }

    @GetMapping("/available")
    public ResponseEntity<Page<PizzaEntity>> getAvailable(@RequestParam(defaultValue = "0") int page,
                                                          @RequestParam(defaultValue = "8") int elements,
                                                          @RequestParam(defaultValue = "price") String sortBy,
                                                          @RequestParam(defaultValue = "ASC") String sortDirection) {
        return ResponseEntity.ok(this.pizzaService.getAvailable(page, elements, sortBy, sortDirection));
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<PizzaEntity> getByName(@PathVariable String name) {
        return ResponseEntity.ok(this.pizzaService.getByName(name));
    }

    @GetMapping("/with/{ingredient}")
    public ResponseEntity<List<PizzaEntity>> getWith(@PathVariable String ingredient) {
        return ResponseEntity.ok(this.pizzaService.getWith(ingredient));
    }

    @GetMapping("/without/{ingredient}")
    public ResponseEntity<List<PizzaEntity>> getWithout(@PathVariable String ingredient) {
        return ResponseEntity.ok(this.pizzaService.getWithout(ingredient));
    }

    @GetMapping("/cheapest/{price}")
    public ResponseEntity<List<PizzaEntity>> getCheapest(@PathVariable double price) {
        return ResponseEntity.ok(this.pizzaService.getCheapest(price));
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

    @PatchMapping("/price")
    public ResponseEntity<Void> updatePrice(@RequestBody UpdatePizzaPriceDTO dto) {
        ResponseEntity<Void> responseEntity;
        if (this.pizzaService.exists(dto.getPizzaId())) {
            this.pizzaService.updatePrice(dto);
            responseEntity = ResponseEntity.ok().build();
        } else {
            responseEntity = ResponseEntity.badRequest().build();
        }
        return responseEntity;
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
