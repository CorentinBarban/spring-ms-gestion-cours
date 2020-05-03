package com.stivanin.mathieu.m2.miage.ams.gestioncours;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class GestioncoursApplication {

    public static void main(String[] args) {
        SpringApplication.run(GestioncoursApplication.class, args);
    }

}
