package com.heliant.spring.rest;

import com.heliant.spring.model.FormularPopunjen;
import com.heliant.spring.service.FormularPopunjenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/formularpopunjen")
public class FormularPopunjenController {

    @Autowired
    private FormularPopunjenService service;

    @GetMapping
    public List<FormularPopunjen> getAllFormularPopunjen() {
        return service.getAllFormularPopunjen();
    }

    @GetMapping("/{id}")
    public ResponseEntity<FormularPopunjen> getFormularPopunjenById(@PathVariable Long id) {
        FormularPopunjen formularPopunjen = service.getFormularPopunjenById(id);
        return ResponseEntity.ok(formularPopunjen);
    }

    @PostMapping
    public ResponseEntity<FormularPopunjen> createFormularPopunjen(@RequestBody FormularPopunjen formularPopunjen) {
        FormularPopunjen noviFormularPopunjen = service.saveFormularPopunjen(formularPopunjen);
        return new ResponseEntity<>(noviFormularPopunjen, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FormularPopunjen> updateFormularPopunjen(@PathVariable Long id, @RequestBody FormularPopunjen formularPopunjen) {
        if (service.getFormularPopunjenById(id) != null) {
            formularPopunjen.setId(id);
            FormularPopunjen updatedFormularPopunjen = service.saveFormularPopunjen(formularPopunjen);
            return new ResponseEntity<>(updatedFormularPopunjen, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFormularPopunjen(@PathVariable Long id) {
        service.deleteFormularPopunjen(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
