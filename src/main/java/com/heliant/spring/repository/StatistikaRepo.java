package com.heliant.spring.repository;

import com.heliant.spring.model.Statistika;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;

public interface StatistikaRepo extends JpaRepository<Statistika, Long> {

    int brojacDana(Date date);
}
