package com.nathan.otm.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nathan.otm.models.User;

@Repository
public interface UserRepo extends CrudRepository<User, Long> {
	List<User> findAll();

}
