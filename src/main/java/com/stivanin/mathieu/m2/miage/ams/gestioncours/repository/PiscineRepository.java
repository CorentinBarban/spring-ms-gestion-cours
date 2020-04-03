package com.stivanin.mathieu.m2.miage.ams.gestioncours.repository;

import com.stivanin.mathieu.m2.miage.ams.gestioncours.entities.Piscine;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PiscineRepository extends MongoRepository<Piscine, Long> {
}
