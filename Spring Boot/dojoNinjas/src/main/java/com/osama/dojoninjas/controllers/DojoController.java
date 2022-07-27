package com.osama.dojoninjas.controllers;

import com.osama.dojoninjas.models.Dojo;
import com.osama.dojoninjas.services.DojoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class DojoController {
    private final DojoService dojoService;

    public DojoController(DojoService dojoService){
        this.dojoService = dojoService;
    }

    // Retrieve Page
    @RequestMapping(value = "/dojo/{id}", method = RequestMethod.GET)
    public String showDojo(@PathVariable(value = "id") long id, Model model, @ModelAttribute("dojo") Dojo dojo){
        Dojo dojo1 = dojoService.findDojo(id);
        model.addAttribute("dojos", dojo1);
        return "show.jsp";
    }

    // Create new Dojo
    @RequestMapping("/dojo/new")
    public String create(@ModelAttribute ("dojo") Dojo dojo){
        return "index.jsp";
    }
    @RequestMapping(value = "/dojo/new", method = RequestMethod.POST)
    public String createDojo(@Valid @ModelAttribute("dojo")Dojo dojo, BindingResult result){
        if (result.hasErrors()){
            return "index.jsp";
        }else {
            dojoService.createDojo(dojo);
            return "redirect:/dojo/new";
        }
    }
}
