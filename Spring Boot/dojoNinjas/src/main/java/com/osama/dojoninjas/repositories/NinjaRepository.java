package com.osama.dojoninjas.repositories;

import com.osama.dojoninjas.models.Ninja;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface NinjaRepository extends CrudRepository <Ninja, Long> {
    public List <Ninja> findAll();
}
