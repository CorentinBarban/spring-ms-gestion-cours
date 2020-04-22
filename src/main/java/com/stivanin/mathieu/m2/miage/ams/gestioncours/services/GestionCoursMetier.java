package com.stivanin.mathieu.m2.miage.ams.gestioncours.services;

import com.stivanin.mathieu.m2.miage.ams.gestioncours.entities.Cours;
import com.stivanin.mathieu.m2.miage.ams.gestioncours.entities.Piscine;
import com.stivanin.mathieu.m2.miage.ams.gestioncours.exceptions.BadDateException;
import com.stivanin.mathieu.m2.miage.ams.gestioncours.exceptions.CoursNotFoundException;
import com.stivanin.mathieu.m2.miage.ams.gestioncours.exceptions.PiscineNotFoundException;

import java.util.Optional;


public interface GestionCoursMetier {

    /**
     * Lister tous les cours
     * @return liste de cours
     */
    Iterable<Cours> listerCours(Long idUser);

    /**
     * Lister toutes les piscines
     * @return liste de piscine
     */
    Iterable<Piscine> listerPiscines();

    /**
     * Creer un nouveau cours
     * @param cours Un cours
     * @return Un cours
     * @throws BadDateException
     */
    Cours creerCours(Cours cours) throws BadDateException;

    /**
     * Creer une nouvelle piscine
     * @param piscine Une piscine
     * @return Une piscine
     */
    Piscine creerPiscine(Piscine piscine);

    /**
     * Obtenir les informations d'un cours
     * @param idCours Identifiant d'un cours
     * @return Un cours
     * @throws CoursNotFoundException
     */
    Cours getCours(Long idCours) throws CoursNotFoundException;

    /**
     * Obtenir les informations d'une piscine
     * @param idPiscine Identifiant d'une piscine
     * @return Une piscine
     * @throws PiscineNotFoundException
     */
    Piscine getPiscine(Long idPiscine) throws PiscineNotFoundException;


    Cours inscriptionCours(Long idCours, Long idMembre) throws CoursNotFoundException;


}
