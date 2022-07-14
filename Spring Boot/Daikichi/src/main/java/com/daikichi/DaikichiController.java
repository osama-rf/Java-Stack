package com.daikichi;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController

@RequestMapping("/daikichi")
public class DaikichiController {
    @RequestMapping("/")
    public String hello(){
        return "Welcome";
    }

    @RequestMapping("/today")
    public String today(){
        return "Today you will find luck in all your endeavors!";
    }

    @RequestMapping("/tomorrow")
    public String tomorrow(){
        return "Tomorrow, an opportunity will arise, so be sure to be open to new ideas!";
    }

    @RequestMapping("/travel")
    public String travel(){
        return "Please type the place you want to travel to! 1- Honolulu  2- Kyoto  3- Type random number";
    }

    @RequestMapping("/travel/Honolulu")
    public String honolulu(){
        return "Congratulation! you'll soon will go to Honolulu";
    }

    @RequestMapping("/travel/Kyoto")
    public String kyoto(){
        return "Congratulations! You will soon travel to kyoto!.";
    }

    @RequestMapping("/travel/lotto/{num}")
    public String lotto(@PathVariable("num") int num){
        if (num % 2 == 0){
            return "You will take a grand journey in the near future, but be weary of tempting offers";
        } else {
            return "You have enjoyed the fruits of your labor but now is a great time to spend time with family and friends.";
        }
    }
}
