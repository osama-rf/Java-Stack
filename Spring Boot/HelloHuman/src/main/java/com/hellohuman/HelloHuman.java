package com.hellohuman;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

@SpringBootApplication
@RestController

public class HelloHuman {
    @RequestMapping("/")
    public String index(@RequestParam(value="name", required = false) String searchQuery,
                        @RequestParam(value="last", required = false) String searchQuery1) {
        if (searchQuery1 == null){
            return "You searched for: " + searchQuery;
        } else if (searchQuery1 != null){
            return "You searched for: " + searchQuery +" " + searchQuery1;
        }else {
            return "Please set your name";
        }
    }
}
