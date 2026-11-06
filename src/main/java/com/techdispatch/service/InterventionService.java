package com.techdispatch.service;

import com.techdispatch.model.Intervention;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class InterventionService {

    public List<Intervention> findAll(String statut) {
        return statut == null ? Intervention.listAll() : Intervention.findByStatut(statut);
    }

    public Optional<Intervention> findById(Long id) {
        return Intervention.findByIdOptional(id);
    }

    @Transactional
    public Intervention create(Intervention i) {
        i.statut = "NOUVELLE";
        i.persist();
        return i;
    }

    @Transactional
    public boolean delete(Long id) {
        return Intervention.deleteById(id);
    }

}
