package com.stivanin.mathieu.m2.miage.ams.gestioncours.rest;

import com.stivanin.mathieu.m2.miage.ams.gestioncours.entities.Cours;
import com.stivanin.mathieu.m2.miage.ams.gestioncours.exceptions.BadDateException;
import com.stivanin.mathieu.m2.miage.ams.gestioncours.exceptions.CoursNotFoundException;
import com.stivanin.mathieu.m2.miage.ams.gestioncours.services.GestionCoursMetier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/cours")
public class CoursController {

    Logger logger = LoggerFactory.getLogger(CoursController.class);

    @Autowired
    GestionCoursMetier gestionCoursMetier;

    @GetMapping("/{id}")
    public Cours getCours(@PathVariable("id") Long idCours) {
        logger.info("Obtenir les informations d'un cours");
        try {
            return this.gestionCoursMetier.getCours(idCours);
        } catch (CoursNotFoundException e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Cours Not Found", e);
        }
    }

    @GetMapping("/enseignant")
    public Iterable<Cours> getListeCoursEnseignant(@RequestParam("enseignant") String id) {
        long idl = Long.parseLong(id);
        logger.info("Obtenir la liste des cours");
        logger.info("Option reçue {}", idl);

        return this.gestionCoursMetier.getCoursEnseignant(idl);
    }

    @GetMapping("/participant")
    public Iterable<Cours> getListeCoursParticipant(@RequestParam("participant") String id) {
        long idl = Long.parseLong(id);
        logger.info("Obtenir la liste des cours");
        logger.info("Option reçue {}", idl);

        return this.gestionCoursMetier.getCoursParticipant(idl);
    }


    @PostMapping("")
    public Cours postCours(@RequestBody Cours cours) {

        logger.info("Création d'un nouveau cours " + cours );
        try {
            return this.gestionCoursMetier.creerCours(cours);
        } catch (BadDateException e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "La date renseignée n'est pas correcte", e);
        }
    }

}
