package com.heliant.spring.rest;

import com.heliant.spring.dto.KorisnikRequestDTO;
import com.heliant.spring.model.Korisnik;
import com.heliant.spring.service.KorisnikService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("api/korisnik")
@Api(tags = "Korisnik kontroler", description = "Korisnicki servis")
public class KorisnikController {

    @Autowired
    private KorisnikService service;

    @GetMapping("/get-all")
    @ApiOperation(value = "Vraca sve korisnike")
    public List<Korisnik> getAllKorisnik() {
        return service.getAllKorisnik();
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Vraca korisnika po id")
    public ResponseEntity<Korisnik> getKorisnikById(@PathVariable Long id) {
        Korisnik korisnik = service.getKorisnikById(id);
        return ResponseEntity.ok(korisnik);
    }

    @PostMapping("/create-user")
    @ApiOperation(value = "Kreiranje korisnika")
    public ResponseEntity<Korisnik> createKorisnik(@RequestBody KorisnikRequestDTO requestDTO) {
        Korisnik noviKorisnik = service.saveKorisnik(requestDTO);
        return new ResponseEntity<>(noviKorisnik, HttpStatus.CREATED);
    }

    @PostMapping("/create-admir")
    @ApiOperation(value = "Kreiranje admira")
    public ResponseEntity<Korisnik> createAdmir(@RequestBody KorisnikRequestDTO requestDTO) {
        Korisnik noviKorisnik = service.saveAdmir(requestDTO);
        return new ResponseEntity<>(noviKorisnik, HttpStatus.CREATED);
    }

    @PutMapping("update-korisnik/{id}")
    @ApiOperation(value = "Azuriranje korisnika")
    public ResponseEntity<Korisnik> updateKorisnik(@PathVariable Long id, @RequestBody KorisnikRequestDTO requestDTO) {
        if (service.getKorisnikById(id) != null) {
            Korisnik updatedKorisnik = service.saveKorisnik(requestDTO);
            return new ResponseEntity<>(updatedKorisnik, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("delete-user/{id}")
    @ApiOperation(value = "Brisanje korisnika")
    public ResponseEntity<Void> deleteKorisnik(@PathVariable Long id) {
        service.deleteKorisnik(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
