package com.stivanin.mathieu.m2.miage.ams.gestioncours.entities;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Document(collection="piscines")
public class Piscine {

    @Id
    private Long idPiscine;

    @Field
    private String lieu;
}
