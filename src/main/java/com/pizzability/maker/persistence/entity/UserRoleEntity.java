package com.pizzability.maker.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "user_role")
@IdClass(UserRoleId.class)
@NoArgsConstructor
@Getter
@Setter
public class UserRoleEntity {
    @Id
    @Column(length = 20, nullable = false)
    public String username;

    @Id
    @Column(length = 20, nullable = false)
    public String role;

    @Column(columnDefinition = "DATETIME", name = "granted_date", nullable = false)
    public LocalDateTime grantedDate;

    @ManyToOne
    @JoinColumn(insertable = false, name = "username", referencedColumnName = "username", updatable = false)
    private UserEntity user;
}
