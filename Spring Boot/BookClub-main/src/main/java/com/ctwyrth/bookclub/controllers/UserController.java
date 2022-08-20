package com.ctwyrth.bookclub.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.ctwyrth.bookclub.models.LoginUser;
import com.ctwyrth.bookclub.models.User;
import com.ctwyrth.bookclub.services.UserService;

@Controller
public class UserController {
    // -----------------------variables-----------------------
    @Autowired
    private UserService userService;
    
//    @GetMapping("/home")
//    public String home(HttpSession session, Model model) {
//    	Long userId = (Long) session.getAttribute("user_id");
//    	if (userId == null) {
//    		return "redirect:/";
//    	} else {
//    		User currentUser = userService.findUser(userId);
//    		model.addAttribute("user", currentUser);
//    		return "home.jsp";
//    	}
//    }

    // create new
    @GetMapping("/")
    public String index(Model model) {
    	model.addAttribute("newUser", new User());
    	model.addAttribute("newLogin", new LoginUser());
        return "/users/index.jsp";
    }
    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("newUser") User newUser, BindingResult result, Model model, HttpSession session) {
    	// do validation checks on email and password
    	userService.register(newUser, result);
    	
    	if (result.hasErrors()) {
    		model.addAttribute("newLogin", new LoginUser());
    		return "/users/index.jsp";
    	} else {
    		session.setAttribute("user_id", newUser.getId());
    		return "redirect:/home";
    	}
    }
    
    // login
    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, BindingResult result, Model model, HttpSession session) {
    	User user = userService.login(newLogin, result);
    	if (result.hasErrors()) {
    		model.addAttribute("newUser", new User());
    		return "/users/index.jsp";
    	} else {
    		session.setAttribute("user_id", user.getId());
    		return "redirect:/home";
    	}
    	
    }
    
    // logout
    @GetMapping("/logout")
    public String logout(HttpSession session) {
    	session.invalidate();
    	return "redirect:/";
    }

    // display one found by id
    @GetMapping("/users/{id}")
    public String showOneuserById(@PathVariable("id") Long id, Model model) {
        User userToShow = userService.findUser(id);
        model.addAttribute("user", userToShow);
        return "/users/show.jsp";
    }

    // update one found by id
    @GetMapping("/users/{id}/edit")
    public String edit(@PathVariable("id") Long id, Model model) {
    	User userToShow = userService.findUser(id);
    	model.addAttribute("user", userToShow);
    	return "/users/edit.jsp";
    }
    @PutMapping("/users/{id}")
    public String update(@Valid @ModelAttribute("user") User user, BindingResult result) {
    	if (result.hasErrors()) {
        	return "/users/edit.jsp";
    	} else {
		userService.updateUser(user);
		return "redirect:/users";
    	}
    }

    // delete one
    @DeleteMapping("/users/{id}")
    public String destroy(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }
}