package com.pizzability.maker.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "user")
@NoArgsConstructor
@Getter
@Setter
public class UserEntity {
    @Id
    @Column(length = 20, nullable = false)
    private String username;

    @Column(length = 200, nullable = false)
    private String password;

    @Column(length = 50)
    private String email;

    @Column(columnDefinition = "TINYINT", nullable = false)
    private Boolean locked;

    @Column(columnDefinition = "TINYINT", nullable = false)
    private Boolean disabled;
}
