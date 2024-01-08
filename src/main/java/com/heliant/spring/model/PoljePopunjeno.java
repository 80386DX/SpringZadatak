package com.heliant.spring.model;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;
@Data
@Entity
@Table(name = "polje_popunjeno")
public class PoljePopunjeno {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column(name = "id_formular_popunjen")
    private int idFormularPopunjen;

    @Column(name = "id_polje")
    private int idPolje;

    @Column(name = "vrednost_tekst")
    private String vrednostTekst;

    @Column(name = "vrednost_broj")
    private double vrednostBroj;

    @Column(name = "vreme_kreiranja")
    private Timestamp vremeKreiranja;

    @Column(name = "vreme_poslednje_izmene")
    private Timestamp vremePoslednjeIzmene;
}
