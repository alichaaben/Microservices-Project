package com.biling.biling.service.Impl;

import com.biling.biling.entity.Facture;
import com.biling.biling.repository.FactureRepo;
import com.biling.biling.service.FactureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class FactureServiceImpl implements FactureService {
    @Autowired
    private FactureRepo factureRepo;

    @Override
    public Facture findById(Long id) {
        return factureRepo.findById(id).orElse(null);
    }

    @Override
    public List<Facture> findAll() {
        return factureRepo.findAll();
    }


    @Override
    public Facture insert(Facture entity) {
        return factureRepo.save(entity);
    }

    @Override
    public Facture update(Facture entity) {
        Facture currentFacture = factureRepo.findById(entity.getId()).orElse(null);
        currentFacture.setDateFacture(entity.getDateFacture());
        currentFacture.setCustomerId(entity.getCustomerId());
        return factureRepo.save(currentFacture);
    }


    @Override
    public void deleteById(Long id) {
        factureRepo.deleteById(id);
    }

}
