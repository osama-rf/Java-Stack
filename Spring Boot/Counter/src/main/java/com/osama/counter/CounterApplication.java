package com.osama.counter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@SpringBootApplication
@Controller
public class CounterApplication {

    public static void main(String[] args) {
        SpringApplication.run(CounterApplication.class, args);
    }

//    @RequestMapping("/")
//    public String index(HttpSession session){
//        session.setAttribute("count", 0);
//        return "index.html";
//    }

    // ...
    @RequestMapping("/count")
    public String showCount(HttpSession session, Model model) {
        Integer currentCount = (Integer) session.getAttribute("count");
        model.addAttribute("countToShow", currentCount);
        return "count.jsp";
    }

    @RequestMapping("/")
    public String index(HttpSession session) {

        // If the count is not already in session
        if (session.getAttribute("count") == null) {
            // Use setAttribute to initialize the count in session
            session.setAttribute("count", 0);
        }
        else {
            // increment the count by 1 using getAttribute and setAttribute
            Integer currentCount = (Integer) session.getAttribute("count");
            currentCount++;
            session.setAttribute("count", currentCount);
        }
        return "index.jsp";
    }
// ...
@RequestMapping("/two")
public String count2(HttpSession session) {

    // If the count is not already in session
    if (session.getAttribute("count") == null) {
        // Use setAttribute to initialize the count in session
        session.setAttribute("count", 0);
    }
    else {
        // increment the count by 1 using getAttribute and setAttribute
        Integer currentCount = (Integer) session.getAttribute("count");
        currentCount+=2;
        session.setAttribute("count", currentCount);
    }
    return "count2.jsp";
}
// ...

    @RequestMapping("/reset")
    public String reset(HttpSession session){
        if (session.getAttribute("count") != null){
            session.invalidate();
        }
        session.setAttribute("count", 0);
        return "count.jsp";
    }
}
