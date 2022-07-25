package com.osama.ninjagold;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

@SpringBootApplication
@Controller
public class NinjaGoldApplication {

    public static void main(String[] args) {
        SpringApplication.run(NinjaGoldApplication.class, args);
    }

    public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    @RequestMapping("/gold")
    public String index(HttpSession session, Model model) {

        if (session.getAttribute("gold") == null) {
            session.setAttribute("gold", 0);
        }
        if (session.getAttribute("log") == null) {
            session.setAttribute("log", new ArrayList<String>());
        }
        model.addAttribute("gold", (int) session.getAttribute("gold"));
        model.addAttribute("log", (ArrayList<String>) session.getAttribute("log")); // 5
        return "index.jsp";
    }

    @RequestMapping(value = "/gold", method = RequestMethod.POST)
    public String gold(HttpSession session, @RequestParam(value = "location") String location) {
        if (location.equals("farm")) {
            int earnedGold = getRandomNumber(10, 20);

            session.setAttribute("gold", (int) session.getAttribute("gold") + earnedGold);
            ArrayList<String> newLog = (ArrayList<String>) session.getAttribute("log"); //1
            String message1 = String.format("You have earned %d from farm",earnedGold); // 2
            newLog.add(message1); //3
            session.setAttribute("log",newLog); // 4

        } else if (location.equals("cave")) {
            int earnedGold = getRandomNumber(10, 20);
            session.setAttribute("gold", (int) session.getAttribute("gold") + getRandomNumber(10, 20));
            ArrayList<String> newLog = (ArrayList<String>) session.getAttribute("log");
            String message2 = String.format("You have earned %d from cave", earnedGold);
            newLog.add(message2);
            session.setAttribute("log", newLog);
        } else if (location.equals("house")) {
            int earnedGold = getRandomNumber(10, 20);
            session.setAttribute("gold", (int) session.getAttribute("gold") + getRandomNumber(10, 20));
            ArrayList<String> newLog = (ArrayList<String>) session.getAttribute("log");
            String message3 = String.format("You have earned %d from house", earnedGold);
            newLog.add(message3);
            session.setAttribute("log", newLog);
        } else if (location.equals("quest")) {
            int earnedGold = getRandomNumber(-50, 50);
            session.setAttribute("gold", (int) session.getAttribute("gold") + getRandomNumber(-50, 50));
            ArrayList<String> newLog = (ArrayList<String>) session.getAttribute("log");
            String message4 = "";
            if(earnedGold >= 0){
                message4 = String.format("You have earned %d from quest", earnedGold);
            }else{
                message4 = String.format("You have lose %d from quest", earnedGold);
            }
            newLog.add(message4);
            session.setAttribute("log", newLog);
        }
        return "redirect:/gold";
    }
}
