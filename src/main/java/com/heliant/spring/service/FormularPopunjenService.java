package com.heliant.spring.service;

import com.heliant.spring.model.FormularPopunjen;
import com.heliant.spring.repository.FormularPopunjenRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FormularPopunjenService {

    @Autowired
    private FormularPopunjenRepo repo;

    public List<FormularPopunjen> getAllFormularPopunjen(){
        return repo.findAll();
    }
    public FormularPopunjen getFormularPopunjenById(Long id){
        return repo.findById(id).orElse(null);
    }
    public FormularPopunjen saveFormularPopunjen(FormularPopunjen formular){
        return repo.save(formular);
    }
    public void deleteFormularPopunjen(Long id){
        repo.deleteById(id);
    }
}
