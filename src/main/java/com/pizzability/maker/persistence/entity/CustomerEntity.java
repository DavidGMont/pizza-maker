package com.pizzability.maker.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "customer")
@NoArgsConstructor
@Getter
@Setter
public class CustomerEntity {
    @Id
    @Column(length = 15, name = "id_customer", nullable = false)
    private String idCustomer;

    @Column(length = 60, nullable = false)
    private String name;

    @Column(length = 100)
    private String address;

    @Column(length = 50, nullable = false, unique = true)
    private String email;

    @Column(length = 20, name = "phone_number")
    private String phoneNumber;
}
