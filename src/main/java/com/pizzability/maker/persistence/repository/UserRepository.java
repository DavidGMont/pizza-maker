package com.pizzability.maker.persistence.repository;

import com.pizzability.maker.persistence.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity, String> {
}
