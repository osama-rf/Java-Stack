package com.osama.languages.services;

import com.osama.languages.models.Language;
import com.osama.languages.repositories.LanguageRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LanguageService {
    private final LanguageRepository languageRepository;

    public LanguageService(LanguageRepository languageRepository){
        this.languageRepository = languageRepository;
    }

    // Return all the languages
    public List<Language> allLanguages(){
        return languageRepository.findAll();
    }

    // Create new language
    public Language createLanguage(Language language){
        return languageRepository.save(language);
    }


    public Language findLanguage(Long id){
        Optional<Language> optionalLanguage = languageRepository.findById((id));
        if (optionalLanguage.isPresent()){
            return optionalLanguage.get();
        } else {
            return null;
        }
    }

    public void updateLanguage(Long id, Language language){
        Optional<Language> optionalLanguage = languageRepository.findById(id);
        if (optionalLanguage.isPresent()){
            optionalLanguage.get().setName(language.getName());
            optionalLanguage.get().setCreator(language.getCreator());
            optionalLanguage.get().setCurrentVersion(language.getCurrentVersion());
            languageRepository.save(optionalLanguage.get());
        }
    }

    public void deleteLanguage(Long id){
        Optional<Language> optionalLanguage = languageRepository.findById(id);
        if (optionalLanguage.isPresent()){
            languageRepository.delete((optionalLanguage.get()));
        }
    }
}
