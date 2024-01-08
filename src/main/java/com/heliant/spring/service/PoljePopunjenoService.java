package com.heliant.spring.service;

import com.heliant.spring.model.PoljePopunjeno;
import com.heliant.spring.repository.PoljePopunjenoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PoljePopunjenoService {

    @Autowired
    private PoljePopunjenoRepo repo;

    public List<PoljePopunjeno> getAllPoljePopunjeno(){
        return repo.findAll();
    }
    public PoljePopunjeno getPoljePopunjenoById(Long id){
        return repo.findById(id).orElse(null);
    }
    public PoljePopunjeno savePoljePopunjeno(PoljePopunjeno poljePopunjeno){
        return repo.save(poljePopunjeno);
    }
    public void deletePoljePopunjeno(Long id){
        repo.deleteById(id);
    }
}
