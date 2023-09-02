package com.pizzability.maker.persistence.repository;

import com.pizzability.maker.persistence.entity.PizzaEntity;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PizzaRepository extends ListCrudRepository<PizzaEntity, Integer> {
    List<PizzaEntity> findAllByAvailableTrueOrderByPrice();

    PizzaEntity findAllByAvailableTrueAndNameIgnoreCase(String name);
}
