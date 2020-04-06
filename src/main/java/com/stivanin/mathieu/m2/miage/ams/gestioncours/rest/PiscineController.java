package com.stivanin.mathieu.m2.miage.ams.gestioncours.rest;

import com.stivanin.mathieu.m2.miage.ams.gestioncours.entities.Piscine;
import com.stivanin.mathieu.m2.miage.ams.gestioncours.repository.CoursRepository;
import com.stivanin.mathieu.m2.miage.ams.gestioncours.services.GestionCoursMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController("/piscines")
public class PiscineController {

    @Autowired
    GestionCoursMetier gestionCoursMetier;

    @GetMapping("{id}")
    public Optional<Piscine> getPiscine(@PathVariable("id") Long idPiscine) {
        return this.gestionCoursMetier.getPiscine(idPiscine);
    }

    @GetMapping("")
    public Iterable<Piscine> getListePiscines() {
        return this.gestionCoursMetier.listerPiscines();
    }

    @PostMapping("")
    public Piscine postPiscine(@RequestBody Piscine piscine) {
        return this.gestionCoursMetier.creerPiscine(piscine);
    }
}
