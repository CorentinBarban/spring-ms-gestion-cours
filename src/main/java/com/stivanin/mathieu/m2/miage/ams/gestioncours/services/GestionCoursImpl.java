package com.stivanin.mathieu.m2.miage.ams.gestioncours.services;

import com.stivanin.mathieu.m2.miage.ams.gestioncours.entities.Cours;
import com.stivanin.mathieu.m2.miage.ams.gestioncours.entities.Piscine;
import com.stivanin.mathieu.m2.miage.ams.gestioncours.exceptions.BadDateException;
import com.stivanin.mathieu.m2.miage.ams.gestioncours.exceptions.CoursNotFoundException;
import com.stivanin.mathieu.m2.miage.ams.gestioncours.exceptions.PiscineNotFoundException;
import com.stivanin.mathieu.m2.miage.ams.gestioncours.repository.CoursRepository;
import com.stivanin.mathieu.m2.miage.ams.gestioncours.repository.PiscineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.Optional;

@Service
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
    public Cours creerCours(Cours cours) throws BadDateException {

        Date jour = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(jour);
        c.add(Calendar.DATE, 7); //Projection dans 7j à partir de la date du jour
        Date newDate = c.getTime();

        if (newDate.compareTo(cours.getDate()) < 0) { //Si le cours est dans moins de 7 jours, ce n'est pas bon
            throw new BadDateException("La date d’un cours doit toujours être supérieure de 7 jours calendaires par rapport à la date de saisie. ");
        } else {
            return this.coursRepository.save(cours);
        }

    }

    @Override
    public Piscine creerPiscine(Piscine piscine) {
        return this.piscineRepository.save(piscine);
    }

    @Override
    public Cours getCours(Long idCours) throws CoursNotFoundException {
        if (this.coursRepository.existsById(idCours)) {
            return this.coursRepository.findById(idCours).get();
        } else {
            throw new CoursNotFoundException("Le cours n'existe pas");
        }
    }

    @Override
    public Piscine getPiscine(Long idPiscine) throws PiscineNotFoundException {
        if (this.piscineRepository.existsById(idPiscine)) {
            return this.piscineRepository.findById(idPiscine).get();
        } else {
            throw new PiscineNotFoundException("La piscine n'existe pas");
        }
    }

    @Override
    public Cours inscriptionCours(Long idCours, Long idMembre) throws CoursNotFoundException {
        if (this.coursRepository.existsById(idCours)) {
            Cours cours = this.coursRepository.findById(idCours).get();
            cours.getListeParticipants().add(idMembre);
            return this.coursRepository.save(cours); // A VERIFIER SI CA MET A JOUR ET NON DUPLIQUE LE COURS
        } else {
            throw new CoursNotFoundException("Le cours n'existe pas");
        }
    }
}
