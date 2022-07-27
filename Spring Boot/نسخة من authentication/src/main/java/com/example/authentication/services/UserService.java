package com.example.authentication.services;

import com.example.authentication.models.Book;
import com.example.authentication.models.LoginUser;
import com.example.authentication.models.User;
import com.example.authentication.repositories.BookRepository;
import com.example.authentication.repositories.UserRepository;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    // Register
    public User register(User newUser, BindingResult result){
        if (userRepository.findByEmail(newUser.getEmail()).isPresent()){
            result.rejectValue("email", "Unique", "This email is already in use!");
        }
        if (!newUser.getPassword().equals(newUser.getConfirm())){
            result.rejectValue("confirm", "Matches", "The Confirm Password must match Password!");
        }
        if (result.hasErrors()){
            return null;
        } else {
            String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
            newUser.setPassword(hashed);
            return userRepository.save(newUser);
        }
    }

    // Login

    public User login(LoginUser newLogin, BindingResult result){
        if (result.hasErrors()){
            return null;
        }
        Optional<User> potentialUser = userRepository.findByEmail(newLogin.getEmail());
        if (!potentialUser.isPresent()){
            result.rejectValue("email", "Unique", "Unknown email");
            return null;
        }
        User user = potentialUser.get();
        if (!BCrypt.checkpw(newLogin.getPassword(), user.getPassword())) {
            result.rejectValue("password", "Matches", "Invalid Password!");
        }
        if (result.hasErrors()){
            return null;
        } else {
            return user;
        }
    }

    // Find User By ID:
    public User findUserById(Long id){
        Optional<User> potentialUser = userRepository.findById(id);
        if (potentialUser.isPresent()){
            return potentialUser.get();
        } else {
            return null;
        }
    }
}
