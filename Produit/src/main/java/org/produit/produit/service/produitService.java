package org.produit.produit.service;

import org.produit.produit.entity.Produit;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface produitService {

    Produit findById(Long id);

    List<Produit> findAll();

    Optional<Produit> findByName(String name);

    Produit insert(Produit Entity);

    Produit update(Produit Entity);

    void deleteById(Long id);
}
