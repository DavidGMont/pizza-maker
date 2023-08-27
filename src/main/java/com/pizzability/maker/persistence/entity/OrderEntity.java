package com.pizzability.maker.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "pizza_order")
@NoArgsConstructor
@Getter
@Setter
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_order", nullable = false)
    private Integer idOrder;

    @Column(length = 15, name = "id_customer", nullable = false)
    private String idCustomer;

    @Column(columnDefinition = "DATETIME", nullable = false)
    private LocalDateTime date;

    @Column(columnDefinition = "DECIMAL(6,2)", nullable = false)
    private Double price;

    @Column(columnDefinition = "CHAR(1)", nullable = false)
    private String method;

    @Column(length = 200, name = "additional_notes")
    private String additionalNotes;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_customer", referencedColumnName = "id_customer", insertable = false, updatable = false)
    @JsonIgnore
    private CustomerEntity customer;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "order")
    private List<OrderItemEntity> items;
}
