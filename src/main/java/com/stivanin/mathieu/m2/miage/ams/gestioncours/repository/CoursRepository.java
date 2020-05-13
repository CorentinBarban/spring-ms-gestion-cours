package com.stivanin.mathieu.m2.miage.ams.gestioncours.repository;

import com.stivanin.mathieu.m2.miage.ams.gestioncours.entities.Cours;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CoursRepository extends MongoRepository<Cours, Long> {

    List<Cours> findAllByIdEnseignant(Long idEnseignant);

    List<Cours> findAllByListeParticipantsContains(Long idParticipant);



}
