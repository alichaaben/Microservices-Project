package com.biling.biling.service;

import com.biling.biling.entity.ProduitItems;
import java.util.List;

public interface ProduitItemsService {

    ProduitItems findById(Long id);

    List<ProduitItems> findAll();

    ProduitItems insert(ProduitItems Entity);

    ProduitItems update(ProduitItems Entity);

    void deleteById(Long id);
}
