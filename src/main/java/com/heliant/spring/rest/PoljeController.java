package com.heliant.spring.rest;

import com.heliant.spring.model.Polje;
import com.heliant.spring.service.PoljeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/polje")
public class PoljeController {

    @Autowired
    PoljeService service;

    @GetMapping
    public List<Polje> getAllPolje() {
        return service.getAllPolje();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Polje> getPoljeById(@PathVariable Long id) {
        Polje polje = service.getPoljeById(id);
        return ResponseEntity.ok(polje);
    }

    @PostMapping
    public ResponseEntity<Polje> createPolje(@RequestBody Polje polje) {
        Polje noviPolje = service.savePolje(polje);
        return new ResponseEntity<>(noviPolje, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Polje> updatePolje(@PathVariable Long id, @RequestBody Polje polje) {
        if (service.getPoljeById(id) != null) {
            polje.setId(id);
            Polje updatedPolje = service.savePolje(polje);
            return new ResponseEntity<>(updatedPolje, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePolje(@PathVariable Long id) {
        service.deletePolje(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
