package com.heliant.spring.dto;

import com.heliant.spring.model.Rola;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
@Getter
@Setter
public class KorisnikResponseDTO {

    private String korisnickoIme;
    private Timestamp vremeKreiranja;
    private Timestamp vremePoslednjeIzmene;
    private Rola rola;
}
