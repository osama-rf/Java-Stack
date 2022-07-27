package com.osama.dojoninjas.services;

import com.osama.dojoninjas.models.Dojo;
import com.osama.dojoninjas.repositories.DojoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DojoService {
    private final DojoRepository dojoRepository;

    public DojoService(DojoRepository dojoRepository){
        this.dojoRepository = dojoRepository;
    }

    public List<Dojo> allDojo(){
        return dojoRepository.findAll();
    }

    // Create Dojo
    public void createDojo(Dojo dojo){
        dojoRepository.save(dojo);
    }

    // Return all Dojos
    public Dojo findDojo(long id){
        Optional<Dojo> dojo = dojoRepository.findById(id);
        if (dojo.isPresent()){
            return dojo.get();
        }else {
            return null;
        }
    }
}