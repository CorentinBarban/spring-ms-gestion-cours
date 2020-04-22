package com.stivanin.mathieu.m2.miage.ams.gestioncours.rest;

import com.stivanin.mathieu.m2.miage.ams.gestioncours.entities.Piscine;
import com.stivanin.mathieu.m2.miage.ams.gestioncours.exceptions.PiscineNotFoundException;
import com.stivanin.mathieu.m2.miage.ams.gestioncours.repository.CoursRepository;
import com.stivanin.mathieu.m2.miage.ams.gestioncours.services.GestionCoursMetier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RestController
@RequestMapping("/piscines")
public class PiscineController {

    Logger logger = LoggerFactory.getLogger(PiscineController.class);

    @Autowired
    GestionCoursMetier gestionCoursMetier;

    @GetMapping("/{id}")
    public Piscine getPiscine(@PathVariable("id") Long idPiscine) {
        logger.info("Obtenir les informations d'une piscine");
        try {
            return this.gestionCoursMetier.getPiscine(idPiscine);
        } catch (PiscineNotFoundException e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Piscine Not Found", e);
        }
    }

    @GetMapping("")
    public Iterable<Piscine> getListePiscines() {
        logger.info("Lister toutes les piscines du système");
        return this.gestionCoursMetier.listerPiscines();
    }

    @PostMapping("")
    public Piscine postPiscine(@RequestBody Piscine piscine) {
        logger.info("Création d'une nouvelle piscine : " + piscine);
        return this.gestionCoursMetier.creerPiscine(piscine);
    }
}
