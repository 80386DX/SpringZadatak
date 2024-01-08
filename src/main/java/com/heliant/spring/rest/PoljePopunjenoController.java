package com.heliant.spring.rest;

import com.heliant.spring.model.PoljePopunjeno;
import com.heliant.spring.service.PoljePopunjenoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/poljepopunjeno")
public class PoljePopunjenoController {

    @Autowired
    PoljePopunjenoService service;

    @GetMapping
    public List<PoljePopunjeno> getAllPoljePopunjeno() {
        return service.getAllPoljePopunjeno();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PoljePopunjeno> getPoljePopunjenoById(@PathVariable Long id) {
        PoljePopunjeno poljePopunjeno = service.getPoljePopunjenoById(id);
        return ResponseEntity.ok(poljePopunjeno);
    }

    @PostMapping
    public ResponseEntity<PoljePopunjeno> createPoljePopunjeno(@RequestBody PoljePopunjeno poljePopunjeno) {
        PoljePopunjeno noviPoljePopunjeno = service.savePoljePopunjeno(poljePopunjeno);
        return new ResponseEntity<>(noviPoljePopunjeno, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PoljePopunjeno> updatePoljePopujneno(@PathVariable Long id, @RequestBody PoljePopunjeno poljePopunjeno) {
        if (service.getPoljePopunjenoById(id) != null) {
            poljePopunjeno.setId(id);
            PoljePopunjeno updatedPoljePopunjeno = service.savePoljePopunjeno(poljePopunjeno);
            return new ResponseEntity<>(updatedPoljePopunjeno, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePoljePopunjeno(@PathVariable Long id) {
        service.deletePoljePopunjeno(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
