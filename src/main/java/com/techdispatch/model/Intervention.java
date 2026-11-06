package com.techdispatch.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

@Entity
public class Intervention extends PanacheEntity {
    @NotBlank
    public String titre;
    public String adresse;
    public String statut;

    public static List<Intervention> findByStatut(String statut) {
        return list("statut", statut);
    }
}
