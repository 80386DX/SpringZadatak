package com.heliant.spring.service;

import com.heliant.spring.dto.KorisnikRequestDTO;
import com.heliant.spring.jwt.JwtTokenProvider;
import com.heliant.spring.model.Korisnik;
import com.heliant.spring.model.Rola;
import com.heliant.spring.repository.KorisnikRepo;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.sql.Timestamp;
import java.util.List;

@Service
public class KorisnikService {

    @Autowired
    private KorisnikRepo repo;
    private PasswordEncoder passwordEncoder;
    private JwtTokenProvider jwtTokenProvider;

    public List<Korisnik> getAllKorisnik() {
        return repo.findAll();
    }

    public Korisnik getKorisnikById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public void deleteKorisnik(Long id) {
        repo.deleteById(id);
    }

    public Korisnik saveKorisnik(KorisnikRequestDTO requestDTO) {

        Korisnik noviKorisnik = new Korisnik();
        noviKorisnik.setKorisnickoIme(requestDTO.getKorisnickoIme());
        noviKorisnik.setLozinka(passwordEncoder.encode(requestDTO.getLozinka()));
        noviKorisnik.setRola(Rola.RADNIK);
        noviKorisnik.setVremeKreiranja(new Timestamp(System.currentTimeMillis()));

        return repo.save(noviKorisnik);
    }

    public Korisnik saveAdmir(KorisnikRequestDTO requestDTO) {

        Korisnik noviKorisnik = new Korisnik();
        noviKorisnik.setKorisnickoIme(requestDTO.getKorisnickoIme());
        noviKorisnik.setLozinka(passwordEncoder.encode(requestDTO.getLozinka()));
        noviKorisnik.setRola(Rola.ADMIR);
        noviKorisnik.setVremeKreiranja(new Timestamp(System.currentTimeMillis()));

        return repo.save(noviKorisnik);
    }
}
