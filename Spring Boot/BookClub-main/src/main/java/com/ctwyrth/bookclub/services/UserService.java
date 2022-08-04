package com.ctwyrth.bookclub.services;

import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.ctwyrth.bookclub.models.LoginUser;
import com.ctwyrth.bookclub.models.User;
import com.ctwyrth.bookclub.repositories.UserRepository;

@Service
public class UserService {
	
    @Autowired
    private UserRepository userRepository;
    
    // shows all
    public List<User> allUsers() {
        return userRepository.findAll();
    }

    // creates one -- register
    public User register(User newU, BindingResult result) {
    	Optional<User> potentialUser = userRepository.findByEmail(newU.getEmail());
    	// check for email in db
    	if (potentialUser.isPresent()) {
    		result.rejectValue("email", "Exists", "This email is taken.");
    	}
    	// check password equals confirm
    	if (!newU.getPassword().equals(newU.getConfirm())) {
    		result.rejectValue("confirm", "Matches", "The Confirm Password must match the Password!");
    	}
    	if (result.hasErrors()) {
    		return null;
    	} else {
    		String hashed = BCrypt.hashpw(newU.getPassword(), BCrypt.gensalt());
    		newU.setPassword(hashed);
    		return userRepository.save(newU);
    	}
    }
    
    // login
    public User login(LoginUser loginUser, BindingResult result) {
    	Optional<User> potentialUser = userRepository.findByEmail(loginUser.getEmail());
    	
    	// check if user exists in db through email
    	if (!potentialUser.isPresent()) {
    		result.rejectValue("email", "Exists", "Please try a different email.");
    	} else {
    		// grab the user with the provided email
    		User userForLoginCheck = potentialUser.get();
    		
    		// check if passwords match
    		if(!BCrypt.checkpw(loginUser.getPassword(), userForLoginCheck.getPassword())) {
    			result.rejectValue("password", "Matches", "Invalid Password!");
    		}
    		
    		if (result.hasErrors()) {
    			return null;
    		} else {
    			return userForLoginCheck;
    		}
    	}
    	return null;
    }

    // retrieves one by id
    public User findUser(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        return optionalUser.isPresent() ? optionalUser.get() : null;
//        if(optionalUser.isPresent()) {
//            return optionalUser.get();
//        } else {
//            return null;
//        }
    }

    // updates one
    public User updateUser(User n) {
       	return userRepository.save(n);
    }
    
    // deletes one
    public void deleteUser(Long id) {
    	userRepository.deleteById(id);
    }
    
}