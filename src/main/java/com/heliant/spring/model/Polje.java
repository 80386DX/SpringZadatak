package com.heliant.spring.model;

import jakarta.persistence.*;
import lombok.Data;
import java.sql.Timestamp;
@Data
@Entity
@Table(name = "polje")
public class Polje {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column(name = "id_formular")
    private int idFormular;

    private String naziv;

    @Column(name = "prikazani_redosled")
    private int prikazaniRedosled;

    private Tip tip;

    @Column(name = "vreme_kreiranja")
    private Timestamp vremeKreiranja;

    @Column(name = "vreme_poslednje_izmene")
    private Timestamp vremePoslednjeIzmene;
}

