package com.heliant.spring.repository;

import com.heliant.spring.model.Korisnik;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KorisnikRepo extends JpaRepository<Korisnik, Long> {
}
