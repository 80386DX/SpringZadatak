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


    @PostMapping("/brojac")
    public void countAndSaveForms() {
        service.countAndSaveForms();
    }
}
