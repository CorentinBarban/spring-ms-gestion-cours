package com.stivanin.mathieu.m2.miage.ams.gestioncours.services;

import com.stivanin.mathieu.m2.miage.ams.gestioncours.entities.Piscine;
import com.stivanin.mathieu.m2.miage.ams.gestioncours.exceptions.PiscineNotFoundException;
import com.stivanin.mathieu.m2.miage.ams.gestioncours.repository.PiscineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GestionPiscineImpl implements GestionPiscineMetier {

    @Autowired
    PiscineRepository piscineRepository;

    /**
     * Creer une nouvelle piscine
     *
     * @param piscine Une piscine
     * @return Une piscine
     */
    @Override
    public Piscine creerPiscine(Piscine piscine) {
        return this.piscineRepository.save(piscine);
    }

    /**
     * Obtenir les informations d'une piscine
     *
     * @param idPiscine Identifiant d'une piscine
     * @return Une piscine
     * @throws PiscineNotFoundException
     */
    @Override
    public Piscine getPiscine(Long idPiscine) throws PiscineNotFoundException {
        if (this.piscineRepository.existsById(idPiscine)) {
            return this.piscineRepository.findById(idPiscine).get();
        } else {
            throw new PiscineNotFoundException("La piscine n'existe pas");
        }
    }

    /**
     * Lister toutes les piscines
     *
     * @return liste de piscine
     */
    @Override
    public Iterable<Piscine> listerPiscines() {
        return this.piscineRepository.findAll();
    }
}
