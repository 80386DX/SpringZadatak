package com.heliant.spring.model;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;
@Data
@Entity
@Table(name = "formular")
public class Formular {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    private String naziv;

    @Column(name = "vreme_kreiranja")
    private Timestamp vremeKreiranja;

    @Column(name = "vreme_poslednje_izmene")
    private Timestamp vremePoslednjeIzmene;


}
