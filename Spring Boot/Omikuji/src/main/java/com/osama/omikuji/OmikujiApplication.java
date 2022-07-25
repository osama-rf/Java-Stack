package com.osama.omikuji;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@SpringBootApplication
@Controller
public class OmikujiApplication {

    public static void main(String[] args) {
        SpringApplication.run(OmikujiApplication.class, args);
    }

    @RequestMapping("/")
    public String ret(){
        return "redirect:/omikuji";
    }


    @RequestMapping("/omikuji")
    public String hi(){
        return "index.jsp";
    }

    @RequestMapping(value = "/omikuji/show", method = RequestMethod.POST)
    public String show(Model model,
                       @RequestParam(value = "number") int number,
                       @RequestParam(value = "city") String city,
                       @RequestParam(value = "name") String name,
                       @RequestParam(value = "hobby")String hobby,
                       @RequestParam(value = "living") String living,
                       @RequestParam(value = "message") String message
                       ){
        model.addAttribute("number", number);
        model.addAttribute("city", city);
        model.addAttribute("name", name);
        model.addAttribute("hobby", hobby);
        model.addAttribute("living", living);
        model.addAttribute("message", message);
        return "show.jsp";
    }
}
