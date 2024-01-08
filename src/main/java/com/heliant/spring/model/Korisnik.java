package com.heliant.spring.model;

import jakarta.persistence.*;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
@Entity
@Table(name = "korisnik")
@Data
public class Korisnik {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    @Column(name = "korisnicko_ime")
    private String korisnickoIme;

    private String lozinka;

    @Column(name = "vreme_kreiranja")
    private Timestamp vremeKreiranja;

    @Column(name = "vreme_poslednje_izmene")
    private Timestamp vremePoslednjeIzmene;


}
