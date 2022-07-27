package com.osama.lang.services;

import com.osama.lang.models.Lang;
import com.osama.lang.repositories.LangRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LangService {
    private final LangRepository langRepository;

    public LangService(LangRepository langRepository){
        this.langRepository = langRepository;
    }

    public List<Lang> allLang(){
        return langRepository.findAll();
    }

    // Create Language
    public void creatLang(Lang lang){
        langRepository.save(lang);
    }

    // Return all languages
    public Lang findLang(long id){
        Optional<Lang> lang = langRepository.findById(id);
        if (lang.isPresent()){
            return lang.get();
        } else {
            return null;
        }
    }

    // Delete Language
    public void deleteLang(long id){
        Optional<Lang> lang = langRepository.findById(id);
        if (lang.isPresent()){
            langRepository.delete(lang.get());
        }
    }

    // Update Language
    public void updateLang(long id, Lang lang){
        Optional<Lang> lang1 = langRepository.findById(id);
        if (lang1.isPresent()){
            lang1.get().setName(lang.getName());
            lang1.get().setCreator(lang.getCreator());
            lang1.get().setCurrentVersion(lang.getCurrentVersion());
            langRepository.save(lang1.get());
        }
    }
}
