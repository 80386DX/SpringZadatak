package com.heliant.spring.model;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;
@Data
@Entity
@Table(name = "formular_popunjen")
public class FormularPopunjen {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column(name = "id_formular")
    private int idFormular;

    @Column(name = "vreme_kreiranja", nullable = false)
    private Timestamp vremeKreiranja;

    @Column(name = "vreme_poslednje_izmene")
    private Timestamp vremePoslednjeIzmene;

}
