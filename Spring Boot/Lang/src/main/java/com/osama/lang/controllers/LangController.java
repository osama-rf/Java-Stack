package com.osama.lang.controllers;

import com.osama.lang.models.Lang;
import com.osama.lang.services.LangService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class LangController {

    private final LangService langService;

    public LangController(LangService langService){
        this.langService = langService;
    }

    @RequestMapping("/")
    public String index(){
        return "redirect:/dashboard";
    }

    // Return All language
    @RequestMapping(value = "/dashboard", method = RequestMethod.GET)
    public String languages(Model model, @ModelAttribute("language") Lang lang){
        model.addAttribute("languages", langService.allLang());
        return "index.jsp";
    }

    // Create a new Language
    @RequestMapping(value = "/dashboard", method = RequestMethod.POST)
    public String createLanguage(@Valid @ModelAttribute("language") Lang lang, BindingResult result, RedirectAttributes attr){
        if (result.hasErrors()){
            attr.addFlashAttribute("errors", result.getFieldErrors());
            return "redirect:/dashboard";
        }else {
            langService.creatLang(lang);
            attr.addFlashAttribute("success","Language has been created successfully");
            return "redirect:/dashboard";
        }
    }

    // Show All Languages
    @RequestMapping(value = "/dashboard/{id}", method = RequestMethod.GET)
    public String showLanguage(@PathVariable(value = "id") long id, Model model){
        model.addAttribute("language", langService.findLang(id));
        return "show.jsp";
    }

    // Edit Language
    @RequestMapping(value = "/dashboard/{id}/edit", method = RequestMethod.GET)
    public String editLanguage(@PathVariable(value = "id") long id, Model model){
        model.addAttribute("language", langService.findLang(id));
        return "edit.jsp";
    }

    // Update Language
    @RequestMapping(value = "/dashboard/{id}", method = RequestMethod.PUT)
    public String updateLanguage(@PathVariable(value = "id") long id, @Valid @ModelAttribute("language") Lang lang, BindingResult result, RedirectAttributes attr){
        if (result.hasErrors()){
            attr.addFlashAttribute("errors", result.getFieldErrors());
            return "redirect/dashboard/{id}/edit";
        }else {
            langService.updateLang(id, lang);
            attr.addFlashAttribute("success","Language has been changed successfully");
            return "redirect:/dashboard";
        }
    }

    // Delete Language
    @RequestMapping(value = "/dashboard/{id}", method = RequestMethod.DELETE)
    public String deleteLanguage(@PathVariable(value = "id") long id){
        langService.deleteLang(id);
        return "redirect:/dashboard";
    }
}
