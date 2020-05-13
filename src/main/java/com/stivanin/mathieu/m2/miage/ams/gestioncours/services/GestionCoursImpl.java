package com.stivanin.mathieu.m2.miage.ams.gestioncours.services;

import com.stivanin.mathieu.m2.miage.ams.gestioncours.entities.Cours;
import com.stivanin.mathieu.m2.miage.ams.gestioncours.exceptions.BadDateException;
import com.stivanin.mathieu.m2.miage.ams.gestioncours.exceptions.CoursNotFoundException;
import com.stivanin.mathieu.m2.miage.ams.gestioncours.exceptions.InscriptionException;
import com.stivanin.mathieu.m2.miage.ams.gestioncours.repository.CoursRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class GestionCoursImpl implements GestionCoursMetier {

    @Autowired
    CoursRepository coursRepository;

    /**
     * Lister tous les cours d'un enseignant
     *
     * @return liste de cours
     */
    @Override
    public Iterable<Cours> getCoursEnseignant(Long idEnseignant) {
        return this.coursRepository.findAllByIdEnseignant(idEnseignant);
    }

    /**
     * Lister tous les cours d'un participant
     *
     * @return liste de cours
     */
    @Override
    public Iterable<Cours> getCoursParticipant(Long idParticipant) {
        return this.coursRepository.findAllByListeParticipantsContains(idParticipant);
    }

    /**
     * Créer un nouveau cours
     *
     * @param cours Un cours
     * @return Un cours
     * @throws BadDateException
     */
    @Override
    public Cours creerCours(Cours cours) throws BadDateException {

        Date jour = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(jour);
        c.add(Calendar.DATE, 7); //Projection dans 7j à partir de la date du jour
        Date newDate = c.getTime();

        if (newDate.compareTo(cours.getDate()) > 0) { //Si le cours est dans moins de 7 jours, ce n'est pas bon
            throw new BadDateException("La date d’un cours doit toujours être supérieure de 7 jours calendaires par rapport à la date de saisie. ");
        } else {
            return this.coursRepository.save(cours);
        }

    }

    /**
     * Obtenir les informations d'un cours
     *
     * @param idCours Identifiant d'un cours
     * @return Un cours
     * @throws CoursNotFoundException
     */
    @Override
    public Cours getCours(Long idCours) throws CoursNotFoundException {
        if (this.coursRepository.existsById(idCours)) {
            return this.coursRepository.findById(idCours).get();
        } else {
            throw new CoursNotFoundException("Le cours n'existe pas");
        }
    }

    /**
     * Obtenir la liste de tous les cours
     *
     * @return Les cours
     */
    @Override
    public List<Cours> getListeCours() {
        return this.coursRepository.findAll();
    }


    /**
     * Verifier s'il est possible de s'inscrire à un cours
     *
     * @param idCours
     * @return
     * @throws CoursNotFoundException
     */
    @Override
    public Boolean inscriptionCoursIsPossible(Long idCours) throws CoursNotFoundException {
        if (this.coursRepository.existsById(idCours)) {
            Cours cours = this.coursRepository.findById(idCours).get();
            List<Long> listeParticipants = cours.getListeParticipants();
            if (listeParticipants.size() < 2 && cours.getDate().after(new Date())) {
                return true;
            } else {
                return false;
            }
        } else {
            throw new CoursNotFoundException("La cours n'existe pas");
        }
    }

    /**
     * S'inscrire à un cours en tant que participant
     *
     * @param idCours
     * @param idParticipant
     * @return
     * @throws CoursNotFoundException
     */
    @Override
    public Cours inscriptionCours(Long idCours, Long idParticipant) throws CoursNotFoundException, InscriptionException {
        if (this.coursRepository.existsById(idCours)) {
            if (inscriptionCoursIsPossible(idCours)) {
                Cours cours = this.coursRepository.findById(idCours).get();
                cours.getListeParticipants().add(idParticipant);
                return this.coursRepository.save(cours);
            } else {
                throw new InscriptionException("Impossible de s'inscrire au cours, le quota est atteint");
            }
        } else {
            throw new CoursNotFoundException("Le cours n'existe pas");
        }
    }
}
