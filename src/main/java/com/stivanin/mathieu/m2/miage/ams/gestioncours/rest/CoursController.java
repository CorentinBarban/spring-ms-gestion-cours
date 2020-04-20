package com.stivanin.mathieu.m2.miage.ams.gestioncours.rest;

import com.stivanin.mathieu.m2.miage.ams.gestioncours.entities.Cours;
import com.stivanin.mathieu.m2.miage.ams.gestioncours.exceptions.BadDateException;
import com.stivanin.mathieu.m2.miage.ams.gestioncours.exceptions.CoursNotFoundException;
import com.stivanin.mathieu.m2.miage.ams.gestioncours.services.GestionCoursMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController("/cours")
public class CoursController {

    @Autowired
    GestionCoursMetier gestionCoursMetier;

    @GetMapping("{id}")
    public Cours getCours(@PathVariable("id") Long idCours) throws CoursNotFoundException {
        return this.gestionCoursMetier.getCours(idCours);
    }

    @GetMapping("")
    public Iterable<Cours> getListeCours() {
        return this.gestionCoursMetier.listerCours();
    }

    @PostMapping("")
    public Cours postCours(@RequestBody Cours cours) throws BadDateException {
        return this.gestionCoursMetier.creerCours(cours);
    }

}
