package com.pizzability.maker.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "pizza")
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor
@Getter
@Setter
public class PizzaEntity extends AuditableEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pizza", nullable = false)
    private Integer idPizza;

    @Column(length = 30, nullable = false, unique = true)
    private String name;

    @Column(length = 150, nullable = false)
    private String description;

    @Column(columnDefinition = "DECIMAL(5,2)", nullable = false)
    private Double price;

    @Column(columnDefinition = "TINYINT")
    private Boolean vegetarian;

    @Column(columnDefinition = "TINYINT")
    private Boolean vegan;

    @Column(columnDefinition = "TINYINT", nullable = false)
    private Boolean available;
}
