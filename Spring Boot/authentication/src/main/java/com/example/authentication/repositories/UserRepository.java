package com.example.authentication.repositories;


import com.example.authentication.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository <User, Long> {
    Optional<User> findById(Long id);
    Optional<User> findByEmail(String email);
}
