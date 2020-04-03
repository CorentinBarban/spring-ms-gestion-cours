package com.stivanin.mathieu.m2.miage.ams.gestioncours.entities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

@Document(collection="piscines")
public class Piscine {

    // ID ???

    @Field
    private String lieu;
}
