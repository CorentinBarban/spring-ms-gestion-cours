package com.stivanin.mathieu.m2.miage.ams.gestioncours.services;

import com.stivanin.mathieu.m2.miage.ams.gestioncours.DTO.StatistiquesCours;

public interface GestionStatistiqueMetier {

    /**
     * Obtenir les statistiques concernant les cours
     * @return Object StatistiquesCours
     */
    StatistiquesCours obtenirStatistiqueCours();
}
