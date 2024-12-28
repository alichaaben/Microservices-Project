package org.produit.produit.repositories;

import org.produit.produit.entity.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProduitRepo extends JpaRepository<Produit, Long> {
    Optional<Produit> findByName(String name);
}
