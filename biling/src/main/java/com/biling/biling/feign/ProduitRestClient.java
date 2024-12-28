package com.biling.biling.feign;

import com.biling.biling.dto.ProduitDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.awt.print.Pageable;

@FeignClient(name = "produit")
public interface ProduitRestClient {
    @GetMapping("/produits/{id}")
    ProduitDto GetProduitById(@PathVariable Long id);

    @GetMapping("/Produits")
    PagedModel<ProduitDto>  getAllProduit();
}
