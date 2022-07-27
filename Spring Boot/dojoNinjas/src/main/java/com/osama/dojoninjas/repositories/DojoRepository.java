package com.osama.dojoninjas.repositories;

import com.osama.dojoninjas.models.Dojo;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DojoRepository extends CrudRepository<Dojo, Long> {
    public List<Dojo> findAll();
}
