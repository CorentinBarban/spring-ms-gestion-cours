package com.stivanin.mathieu.m2.miage.ams.gestioncours.services;

import com.stivanin.mathieu.m2.miage.ams.gestioncours.entities.Cours;
import com.stivanin.mathieu.m2.miage.ams.gestioncours.entities.Piscine;
import com.stivanin.mathieu.m2.miage.ams.gestioncours.repository.CoursRepository;
import com.stivanin.mathieu.m2.miage.ams.gestioncours.repository.PiscineRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class GestionCoursImpl implements GestionCoursMetier {

    @Autowired
    PiscineRepository piscineRepository;

    @Autowired
    CoursRepository coursRepository;

    @Override
    public Iterable<Cours> listerCours() {
        return this.coursRepository.findAll();
    }

    @Override
    public Iterable<Piscine> listerPiscines() {
        return this.piscineRepository.findAll();
    }

    @Override
    public Cours creerCours(Cours cours) {
        return this.coursRepository.save(cours);
    }

    @Override
    public Piscine creerPiscine(Piscine piscine) {
        return this.piscineRepository.save(piscine);
    }

    @Override
    public Optional<Cours> getCours(Long idCours) {
        return this.coursRepository.findById(idCours);
    }

    @Override
    public Optional<Piscine> getPiscine(Long idPiscine) {
        return this.piscineRepository.findById(idPiscine);
    }
}
