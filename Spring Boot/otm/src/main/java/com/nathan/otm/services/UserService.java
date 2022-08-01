package com.nathan.otm.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nathan.otm.models.User;
import com.nathan.otm.repositories.UserRepo;

@Service
public class UserService {
	private final UserRepo userRepo;
	public UserService(UserRepo userRepo) {
		this.userRepo = userRepo;
	}
	
	public List<User> allUsers(){
		return userRepo.findAll();
	}
	public User createUser(User user) {
		return userRepo.save(user);
	}

}
