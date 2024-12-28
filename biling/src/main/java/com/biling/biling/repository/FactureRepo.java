package com.biling.biling.repository;

import com.biling.biling.entity.Facture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FactureRepo extends JpaRepository<Facture,Long> {
}
