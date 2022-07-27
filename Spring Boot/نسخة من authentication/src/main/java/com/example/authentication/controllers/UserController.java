package com.example.authentication.controllers;

import com.example.authentication.models.Book;
import com.example.authentication.models.LoginUser;
import com.example.authentication.models.User;
import com.example.authentication.services.BookService;
import com.example.authentication.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    // Return A Data
    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("newUser", new User());
        model.addAttribute("newLogin", new LoginUser());
        return "index.jsp";
    }

    // Register
    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("newUser") User newUser, BindingResult result, Model model, HttpSession session){
        userService.register(newUser, result);
        if (result.hasErrors()){
            model.addAttribute("newLogin", new LoginUser());
            return "index.jsp";
        }
        session.setAttribute("user_id", newUser.getId());
        return "redirect:/book";
    }

    // End Of Registration

    // Login
    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, BindingResult result, Model model, HttpSession session){
        User user = userService.login(newLogin, result);
        if (result.hasErrors()) {
            model.addAttribute("newUser", new User());
            return "index.jsp";
        }
        session.setAttribute("user_id", user.getId());
        return "redirect:/book";
    }

//    @GetMapping("/book")
//    public String home(Model model, HttpSession session){
//        Long user_id = (Long) session.getAttribute("user_id");
//        if (user_id != null){
//            User user = userService.findUserById(user_id);
//            model.addAttribute("user", user);
//            return "home.jsp";
//        }else {
//            return "redirect:/";
//        }
//    }

    // End Of Login //

    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.removeAttribute("user_id");
        return "redirect:/";
    }
}
