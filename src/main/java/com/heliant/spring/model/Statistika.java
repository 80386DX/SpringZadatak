package com.heliant.spring.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
@Data
@Entity
@Table(name = "statistika")
public class Statistika {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    private Date datum;

    @Column(name = "broj_popunjenih_formulara")
    private int brojPopunjenihFormulara;
}
