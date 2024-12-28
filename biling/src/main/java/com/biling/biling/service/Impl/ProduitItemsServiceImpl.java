package com.biling.biling.service.Impl;

import com.biling.biling.entity.Facture;
import com.biling.biling.entity.ProduitItems;
import com.biling.biling.repository.ProduitItemsRepo;
import com.biling.biling.service.ProduitItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProduitItemsServiceImpl implements ProduitItemsService {
    @Autowired
    private ProduitItemsRepo produitItemsRepo;

    @Override
    public ProduitItems findById(Long id) {
        return produitItemsRepo.findById(id).orElse(null);
    }

    @Override
    public List<ProduitItems> findAll() {
        return produitItemsRepo.findAll();
    }


    @Override
    public ProduitItems insert(ProduitItems entity) {
        return produitItemsRepo.save(entity);
    }

    @Override
    public ProduitItems update(ProduitItems entity) {
        ProduitItems currentProdItems = produitItemsRepo.findById(entity.getId()).orElse(null);
        currentProdItems.setFacture(entity.getFacture());
        currentProdItems.setPrice(entity.getPrice());
        currentProdItems.setQuantity(entity.getQuantity());
        currentProdItems.setProduitId(entity.getProduitId());

        return produitItemsRepo.save(currentProdItems);
    }


    @Override
    public void deleteById(Long id) {
        produitItemsRepo.deleteById(id);
    }

}
