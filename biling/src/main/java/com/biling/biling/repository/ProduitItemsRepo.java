package com.biling.biling.repository;

import com.biling.biling.entity.ProduitItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProduitItemsRepo extends JpaRepository<ProduitItems, Long> {
}
