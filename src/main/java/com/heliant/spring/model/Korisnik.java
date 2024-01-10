package com.heliant.spring.model;

import jakarta.persistence.*;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.sql.Timestamp;
@Entity
@Table(name = "korisnik")
@Data
public class Korisnik {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column(name = "korisnicko_ime", unique = true, nullable = false)
    private String korisnickoIme;

    @Column(nullable = false)
    private String lozinka;

    @Column(name = "vreme_kreiranja", nullable = false)
    private Timestamp vremeKreiranja;

    @Column(name = "vreme_poslednje_izmene")
    private Timestamp vremePoslednjeIzmene;

    @ElementCollection(fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    private Rola rola;

}
