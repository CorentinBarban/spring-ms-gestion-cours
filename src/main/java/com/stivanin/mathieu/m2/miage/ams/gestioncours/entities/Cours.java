package com.stivanin.mathieu.m2.miage.ams.gestioncours.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Document(collection="cours")
public class Cours {

    @Id
    private Long idCours;

    @Field
    private String nom;

    @Field
    private int niveauCible;

    @Field
    private String creneau;

    @Field
    private Date date;

    @Field
    private Long duree;

    @Field
    private Long idEnseignant;

    @Field
    private String idPiscine;

    @Field
    List<Long> listeParticipants;

}
