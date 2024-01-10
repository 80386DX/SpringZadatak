package com.heliant.spring.service;

import com.heliant.spring.model.PoljePopunjeno;
import com.heliant.spring.model.Statistika;
import com.heliant.spring.repository.PoljePopunjenoRepo;
import com.heliant.spring.repository.StatistikaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class StatistikaService {

    @Autowired
    private StatistikaRepo repo;

    @Scheduled(cron = "0 0 0 * * *")
    public void countAndSaveForms() {
        Date currentDate = new Date();

        Calendar midnight = Calendar.getInstance();
        midnight.setTime(currentDate);
        midnight.set(Calendar.HOUR_OF_DAY, 0);
        midnight.set(Calendar.MINUTE, 0);
        midnight.set(Calendar.SECOND, 0);

        Date midnightDate = midnight.getTime();

        int numberOfForms = countFormsForDate(midnightDate);

        Statistika statistika = new Statistika();
        statistika.setDatum(midnightDate);
        statistika.setBrojPopunjenihFormulara(numberOfForms);

        repo.save(statistika);
    }

    private int countFormsForDate(Date date) {
        return repo.brojacDana(date);
    }

}
