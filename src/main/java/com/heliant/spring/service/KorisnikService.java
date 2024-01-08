package com.heliant.spring.service;

import com.heliant.spring.model.Korisnik;
import com.heliant.spring.repository.KorisnikRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KorisnikService {

    @Autowired
    private KorisnikRepo repo;

    public List<Korisnik> getAllKorisnik(){
        return repo.findAll();
    }
    public Korisnik getKorisnikById(Long id){
        return repo.findById(id).orElse(null);
    }
    public Korisnik saveKorisnik(Korisnik korisnik){
        return repo.save(korisnik);
    }
    public void deleteKorisnik(Long id){
        repo.deleteById(id);
    }
}
