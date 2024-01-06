package com.heliant.spring.model;

import jakarta.persistence.*;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
@Entity
@Table(name = "korisnik")
public class Korisnik {

    @Setter
    @Getter
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    @Setter
    @Getter
    @Column(name = "korisnicko_ime")
    private String korisnickoIme;

    private String lozinka;

    @Setter
    @Getter
    @Column(name = "vreme_kreiranja")
    private Timestamp vremeKreiranja;

    @Setter
    @Getter
    @Column(name = "vreme_poslednje_izmene")
    private Timestamp vremePoslednjeIzmene;


}
