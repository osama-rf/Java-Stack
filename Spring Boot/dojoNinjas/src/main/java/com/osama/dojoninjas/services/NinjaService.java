package com.osama.dojoninjas.services;

import com.osama.dojoninjas.models.Ninja;
import com.osama.dojoninjas.repositories.NinjaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {
    private final NinjaRepository ninjaRepository;

    public NinjaService(NinjaRepository ninjaRepository){
        this.ninjaRepository = ninjaRepository;
    }

    public List<Ninja> allNinja(){
        return ninjaRepository.findAll();
    }

    //Create Ninjas
    public void createNinja(Ninja ninja){
        ninjaRepository.save(ninja);
    }

    //Return All Ninjas
    public Ninja findNinja(Long id){
        Optional<Ninja> ninja = ninjaRepository.findById(id);
        if (ninja.isPresent()){
            return ninja.get();
        } else {
            return null;
        }
    }
}
