package com.pizzability.maker.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "order_item")
@NoArgsConstructor
@Setter
@Getter
public class OrderItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_item")
    private Integer idItem;

    @Column(name = "id_pizza", nullable = false)
    private Integer idPizza;

    @Column(name = "id_order", nullable = false)
    private Integer idOrder;

    @Column(columnDefinition = "DECIMAL(2,1)", nullable = false)
    private Double quantity;

    @Column(columnDefinition = "DECIMAL(5,2)", nullable = false)
    private Double price;
}
