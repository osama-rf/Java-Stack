package com.osama.languages.repositories;

import com.osama.languages.models.Language;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LanguageRepository extends CrudRepository<Language, Long> {
    public List<Language> findAll();
}
