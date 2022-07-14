package com.hellohuman;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@Controller
public class HelloHumanApplication {

    public static void main(String[] args) {
        SpringApplication.run(HelloHumanApplication.class, args);
    }

//    @RequestMapping("/")
//    public String demo() {
//        return "demo.jsp";
//
//    }
}
