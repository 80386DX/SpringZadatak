package com.heliant.spring.service;

import com.heliant.spring.model.Polje;
import com.heliant.spring.repository.PoljeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PoljeService {

    @Autowired
    private PoljeRepo repo;

    public List<Polje> getAllPolje(){
        return repo.findAll();
    }
    public Polje getPoljeById(Long id){
        return repo.findById(id).orElse(null);
    }
    public Polje savePolje(Polje polje){
        return repo.save(polje);
    }
    public void deletePolje(Long id){
        repo.deleteById(id);
    }
}
