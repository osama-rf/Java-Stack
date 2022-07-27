package com.osama.dojoninjas.controllers;

import com.osama.dojoninjas.models.Dojo;
import com.osama.dojoninjas.models.Ninja;
import com.osama.dojoninjas.services.DojoService;
import com.osama.dojoninjas.services.NinjaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

@Controller
public class NinjaController {

    @Autowired
    private final DojoService dojoService;
    private final NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService, DojoService dojoService){
        this.ninjaService = ninjaService;
        this.dojoService = dojoService;
    }

    @RequestMapping("/ninjas/new")
        public String create(@ModelAttribute ("ninja") Ninja ninja, Model model){
        List<Dojo> dojos = dojoService.allDojo();
        model.addAttribute("dojos",dojos);
        return "new.jsp";
    }
    @RequestMapping(value = "/ninjas/new", method = RequestMethod.POST)
    public String createDojo(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result){
        if (result.hasErrors()){
            return "new.jsp";
        }else {
            ninjaService.createNinja(ninja);
            return  "redirect:/ninjas/new";
        }
    }
}
