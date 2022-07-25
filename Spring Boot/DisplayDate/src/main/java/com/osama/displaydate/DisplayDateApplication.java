package com.osama.displaydate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@Controller
public class DisplayDateApplication {

    public static void main(String[] args) {
        SpringApplication.run(DisplayDateApplication.class, args);
    }

    @RequestMapping("/")
    public String index(){
        return "index.jsp";
    }

    @RequestMapping("/date")
    public String date(){
        return "date.jsp";
    }

    @RequestMapping("/time")
    public String time(){
        return "time.jsp";
    }
}
