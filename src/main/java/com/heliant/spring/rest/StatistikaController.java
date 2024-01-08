package com.heliant.spring.rest;

import com.heliant.spring.model.PoljePopunjeno;
import com.heliant.spring.model.Statistika;
import com.heliant.spring.service.StatistikaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/statistika")
public class StatistikaController {

    @Autowired
    StatistikaService service;

    @GetMapping
    public List<Statistika> getAllStatistika() {
        return service.getAllStatistika();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Statistika> getStatistikaById(@PathVariable Long id) {
        Statistika statistika = service.getStatistikaById(id);
        return ResponseEntity.ok(statistika);
    }

    @PostMapping
    public ResponseEntity<PoljePopunjeno> createPoljePopunjeno(@RequestBody PoljePopunjeno poljePopunjeno) {
        PoljePopunjeno noviPoljePopunjeno = service.savePoljePopunjeno(poljePopunjeno);
        return new ResponseEntity<>(noviPoljePopunjeno, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Statistika> updateStatistika(@PathVariable Long id, @RequestBody Statistika statistika) {
        if (service.getStatistikaById(id) != null) {
            statistika.setId(id);
            Statistika updatedStatistika = service.saveStatistika(statistika);
            return new ResponseEntity<>(updatedStatistika, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStatistika(@PathVariable Long id) {
        service.getStatistikaById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
