package com.heliant.spring.rest;

import com.heliant.spring.model.Korisnik;
import com.heliant.spring.service.KorisnikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("api/korisnik")
public class KorisnikController {

    @Autowired
    private KorisnikService service;

    @GetMapping
    public List<Korisnik> getAllKorisnik() {
        return service.getAllKorisnik();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Korisnik> getKorisnikById(@PathVariable Long id) {
        Korisnik korisnik = service.getKorisnikById(id);
        return ResponseEntity.ok(korisnik);
    }

    @PostMapping
    public ResponseEntity<Korisnik> createKorisnik(@RequestBody Korisnik korisnik) {
        Korisnik noviKorisnik = service.saveKorisnik(korisnik);
        return new ResponseEntity<>(noviKorisnik, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Korisnik> updateKorisnik(@PathVariable Long id, @RequestBody Korisnik korisnik) {
        if (service.getKorisnikById(id) != null) {
            korisnik.setId(id);
            Korisnik updatedKorisnik = service.saveKorisnik(korisnik);
            return new ResponseEntity<>(updatedKorisnik, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteKorisnik(@PathVariable Long id) {
        service.deleteKorisnik(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
