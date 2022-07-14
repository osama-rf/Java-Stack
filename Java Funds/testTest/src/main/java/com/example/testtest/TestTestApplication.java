package com.example.testtest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
@SpringBootApplication
@RestController

public class TestTestApplication {
//    @RequestMapping("/hello")
    public static void main(String[] args) {
        SpringApplication.run(TestTestApplication.class, args);
    }
        @RequestMapping("/m/{track}/{module}/{lesson}")
        public String showLesson(@PathVariable("track") String track, @PathVariable("module") String module, @PathVariable("lesson") String lesson){
            return "Track: " + track + ", Module: " + module + ", Lesson: " + lesson;
        }
}
