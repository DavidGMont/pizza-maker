package com.pizzability.maker.persistence.repository;

import com.pizzability.maker.persistence.entity.PizzaEntity;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PizzaRepository extends ListCrudRepository<PizzaEntity, Integer> {
}
