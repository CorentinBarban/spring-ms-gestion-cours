package com.stivanin.mathieu.m2.miage.ams.gestioncours.services;

import com.stivanin.mathieu.m2.miage.ams.gestioncours.DTO.StatistiquesCours;
import com.stivanin.mathieu.m2.miage.ams.gestioncours.repository.CoursRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class GestionStatistiqueImpl implements GestionStatistiqueMetier{


    @Autowired
    CoursRepository coursRepository;

    /**
     * Obtenir les statistiques concernant les cours
     *
     * @return Object StatistiquesCours
     */
    @Override
    public StatistiquesCours obtenirStatistiqueCours() {

        Integer nbCoursPostionnes = this.coursRepository.countByDateAfter(new Date());
        return new StatistiquesCours(nbCoursPostionnes);
    }
}
