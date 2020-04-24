package com.stivanin.mathieu.m2.miage.ams.gestioncours.services;

import com.stivanin.mathieu.m2.miage.ams.gestioncours.entities.Piscine;
import com.stivanin.mathieu.m2.miage.ams.gestioncours.exceptions.PiscineNotFoundException;

public interface GestionPiscineMetier {

    /**
     * Creer une nouvelle piscine
     * @param piscine Une piscine
     * @return Une piscine
     */
    Piscine creerPiscine(Piscine piscine);

    /**
     * Obtenir les informations d'une piscine
     * @param idPiscine Identifiant d'une piscine
     * @return Une piscine
     * @throws PiscineNotFoundException
     */
    Piscine getPiscine(Long idPiscine) throws PiscineNotFoundException;

    /**
     * Lister toutes les piscines
     * @return liste de piscine
     */
    Iterable<Piscine> listerPiscines();
}
