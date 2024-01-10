package com.heliant.spring.rest;

import com.heliant.spring.model.Formular;
import com.heliant.spring.service.FormularService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/formular")
@PreAuthorize("")
public class FormularController {

    @Autowired
    private FormularService service;

    @GetMapping
    public List<Formular> getAllFormular() {
        return service.getAllFormular();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Formular> getFormularById(@PathVariable Long id) {
        Formular formular = service.getFormularById(id);
        return ResponseEntity.ok(formular);
    }

    @PostMapping
    public ResponseEntity<Formular> createFormular(@RequestBody Formular formular) {
        Formular noviFormular = service.saveFormular(formular);
        return new ResponseEntity<>(noviFormular, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Formular> updateFormular(@PathVariable Long id, @RequestBody Formular formular) {
        if (service.getFormularById(id) != null) {
            formular.setId(id);
            Formular updatedFormular = service.saveFormular(formular);
            return new ResponseEntity<>(updatedFormular, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFormular(@PathVariable Long id) {
        service.deleteFormular(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
