package com.stivanin.mathieu.m2.miage.ams.gestioncours.services;

import com.stivanin.mathieu.m2.miage.ams.gestioncours.entities.Cours;
import com.stivanin.mathieu.m2.miage.ams.gestioncours.exceptions.BadDateException;
import com.stivanin.mathieu.m2.miage.ams.gestioncours.exceptions.CoursNotFoundException;
import com.stivanin.mathieu.m2.miage.ams.gestioncours.exceptions.InscriptionException;

import java.util.List;


public interface GestionCoursMetier {

    /**
     * Lister tous les cours d'un enseignant
     *
     * @return liste de cours
     */
    Iterable<Cours> getCoursEnseignant(Long idEnseignant);

    /**
     * Lister tous les cours d'un participant
     *
     * @return liste de cours
     */
    Iterable<Cours> getCoursParticipant(Long idParticipant);

    /**
     * Creer un nouveau cours
     *
     * @param cours Un cours
     * @return Un cours
     * @throws BadDateException
     */
    Cours creerCours(Cours cours) throws BadDateException;

    /**
     * Obtenir les informations d'un cours
     *
     * @param idCours Identifiant d'un cours
     * @return Un cours
     * @throws CoursNotFoundException
     */
    Cours getCours(Long idCours) throws CoursNotFoundException;


    /**
     * Obtenir la liste de tous les cours
     *
     * @return Les cours
     */
    List<Cours> getListeCours();

    /**
     * Verifier s'il est possible de s'inscrire à un cours
     *
     * @param idCours
     * @return
     * @throws CoursNotFoundException
     */
    Boolean inscriptionCoursIsPossible(Long idCours) throws CoursNotFoundException;

    /**
     * S'inscrire à un cours en tant que participant
     *
     * @param idCours
     * @param idParticipant
     * @return
     * @throws CoursNotFoundException
     */
    Cours inscriptionCours(Long idCours, Long idParticipant) throws CoursNotFoundException, InscriptionException;


}
