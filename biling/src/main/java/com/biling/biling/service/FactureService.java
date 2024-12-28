package com.biling.biling.service;

import com.biling.biling.entity.Facture;

import java.util.List;

public interface FactureService {
    Facture findById(Long id);

    List<Facture> findAll();

    Facture insert(Facture Entity);

    Facture update(Facture Entity);

    void deleteById(Long id);
}
