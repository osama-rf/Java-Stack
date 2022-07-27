package com.osama.languages.controllers;

import com.osama.languages.models.Language;
import com.osama.languages.repositories.LanguageRepository;
import com.osama.languages.services.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class LanguageController {

    @Autowired
    LanguageService languageService;

    @RequestMapping("/dashboard")
    public String newLanguage(Model model, @ModelAttribute("languages")Language language){
        List<Language> languages = languageService.allLanguages();
        model.addAttribute("languages", languages);
        return "index.jsp";
    }


    @RequestMapping(value = "/dashboard", method = RequestMethod.POST)
    public String addLanguage(@Valid @ModelAttribute("languages")Language language, BindingResult result){
        if (result.hasErrors()){
            return "index.jsp";
        } else {
            languageService.createLanguage(language);
            return "redirect/dashboard";
        }
    }

    @GetMapping("/dashboard/show/{id}")
    public String showLanguage(Model model, @PathVariable("id") Long id){
        Language language = languageService.findLanguage(id);
        model.addAttribute("languages", language);
        return "show.jsp";
    }
}
