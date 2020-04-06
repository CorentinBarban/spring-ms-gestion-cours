package com.stivanin.mathieu.m2.miage.ams.gestioncours.services;

import com.stivanin.mathieu.m2.miage.ams.gestioncours.entities.Cours;
import com.stivanin.mathieu.m2.miage.ams.gestioncours.entities.Piscine;

import java.util.Optional;

public interface GestionCoursMetier {

    Iterable<Cours> listerCours();

    Iterable<Piscine> listerPiscines();

    Cours creerCours(Cours cours);

    Piscine creerPiscine(Piscine piscine);

    Optional<Cours> getCours(Long idCours);

    Optional<Piscine> getPiscine(Long idPiscine);
}
