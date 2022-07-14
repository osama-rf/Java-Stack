package com.example.testtest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@SpringBootApplication
@RestController

public class TestTestApplication {
//    @RequestMapping("/hello")
    public static void main(String[] args) {
        SpringApplication.run(TestTestApplication.class, args);
    }
    @RequestMapping("/")
    public String index(@RequestParam(value="q", required = false) String searchQuery) {
        return "You searched for: " + searchQuery;
    }
//
//    @RequestMapping("/world")
//    public String world(){
//        return "Class level annotations are cool too";
//    }

}
