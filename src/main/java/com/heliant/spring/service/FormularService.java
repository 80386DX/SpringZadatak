package com.heliant.spring.service;

import com.heliant.spring.model.Formular;
import com.heliant.spring.repository.FormularRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FormularService {

    @Autowired
    private FormularRepo formularRepo;

    public List<Formular> getAllFormular(){
        return formularRepo.findAll();
    }
    public Formular getFormularById(Long id){
        return formularRepo.findById(id).orElse(null);
    }
    public Formular saveFormular(Formular formular){
        return formularRepo.save(formular);
    }
    public void deleteFormular(Long id){
        formularRepo.deleteById(id);
    }

}
