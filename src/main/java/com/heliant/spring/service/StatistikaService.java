package com.heliant.spring.service;

import com.heliant.spring.model.PoljePopunjeno;
import com.heliant.spring.model.Statistika;
import com.heliant.spring.repository.PoljePopunjenoRepo;
import com.heliant.spring.repository.StatistikaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatistikaService {

    @Autowired
    private StatistikaRepo repo;

    public List<Statistika> getAllStatistika(){
        return repo.findAll();
    }
    public Statistika getStatistikaById(Long id){
        return repo.findById(id).orElse(null);
    }
    public Statistika saveStatistika(Statistika statistika){
        return repo.save(statistika);
    }
    public void deleteStatistika(Long id){
        repo.deleteById(id);
    }

}
