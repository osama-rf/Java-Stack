package com.osama.lang.repositories;

import com.osama.lang.models.Lang;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LangRepository extends CrudRepository <Lang, Long> {
    public List<Lang> findAll();
}
