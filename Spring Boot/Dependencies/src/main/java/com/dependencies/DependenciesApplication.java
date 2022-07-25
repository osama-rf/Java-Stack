package com.dependencies;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@Controller
public class DependenciesApplication {

    public static void main(String[] args) {
        SpringApplication.run(DependenciesApplication.class, args);

    }
    @RequestMapping("/")
    public String home(Model model){
        String firstName = "osama";
        String lastName = "alrefae";
        String email = "osama@gmail.com";
        Integer age = 24;

        model.addAttribute("first", firstName);
        model.addAttribute("last", lastName);
        model.addAttribute("email", email);
        model.addAttribute("age", age);
        return "index.jsp";
    }
}
