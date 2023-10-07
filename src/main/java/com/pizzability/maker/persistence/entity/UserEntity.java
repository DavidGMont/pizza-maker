package com.pizzability.maker.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

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

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
    private List<UserRoleEntity> roles;
}
