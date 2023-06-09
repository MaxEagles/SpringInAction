package com.maxeagles.spring;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<TacoUser, Long> {
    TacoUser findByUsername(String username);
}
