package org.produit.produit.service.impl;

import org.produit.produit.entity.Produit;
import org.produit.produit.repositories.ProduitRepo;
import org.produit.produit.service.produitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProduitServiceImpl implements produitService {

    @Autowired
    private ProduitRepo ProduitRepo;

    @Override
    public Produit findById(Long id) {
        return ProduitRepo.findById(id).orElse(null);
    }

    @Override
    public List<Produit> findAll() {
        return ProduitRepo.findAll();
    }

    @Override
    public Optional<Produit> findByName(String name) {
        return ProduitRepo.findByName(name);
    }



    @Override
    public Produit insert(Produit Entity) {
        return ProduitRepo.save(Entity);
    }

    @Override
    public Produit update(Produit Entity) {
        Produit currentProduit= ProduitRepo.findById(Entity.getId()).get();
        currentProduit.setName(Entity.getName());
        currentProduit.setPrice(Entity.getPrice());
        currentProduit.setQuantite(Entity.getQuantite());
        return ProduitRepo.save(currentProduit);
    }

    @Override
    public void deleteById(Long id) {
        ProduitRepo.deleteById(id);
    }


}
