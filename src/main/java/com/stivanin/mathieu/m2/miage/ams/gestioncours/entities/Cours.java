package com.stivanin.mathieu.m2.miage.ams.gestioncours.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

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
    private long duree;

    //Enseignant ? Cf sujet

}
