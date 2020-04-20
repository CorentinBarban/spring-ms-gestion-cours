package com.stivanin.mathieu.m2.miage.ams.gestioncours.services;

import com.stivanin.mathieu.m2.miage.ams.gestioncours.entities.Cours;
import com.stivanin.mathieu.m2.miage.ams.gestioncours.entities.Piscine;
import com.stivanin.mathieu.m2.miage.ams.gestioncours.exceptions.BadDateException;
import com.stivanin.mathieu.m2.miage.ams.gestioncours.exceptions.CoursNotFoundException;
import com.stivanin.mathieu.m2.miage.ams.gestioncours.exceptions.PiscineNotFoundException;

import java.util.Optional;

public interface GestionCoursMetier {

    Iterable<Cours> listerCours();

    Iterable<Piscine> listerPiscines();

    Cours creerCours(Cours cours) throws BadDateException;

    Piscine creerPiscine(Piscine piscine);

    Cours getCours(Long idCours) throws CoursNotFoundException;

    Piscine getPiscine(Long idPiscine) throws PiscineNotFoundException;

    Cours inscriptionCours(Long idCours, Long idMembre) throws CoursNotFoundException;

    //Gestion des exceptions (Piscine not found, Cours not found)

}
