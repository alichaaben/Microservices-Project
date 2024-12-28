package org.produit.produit.controller;

import org.produit.produit.dto.ProduitDto;
import org.produit.produit.entity.Produit;
import org.produit.produit.mapper.ProduitMapper;
import org.produit.produit.service.produitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/Produits")
public class ProduitController {
    @Autowired
    private produitService produitService;
    @Autowired
    private ProduitMapper produitMapper;

    @GetMapping("/{id}")
    public ResponseEntity<ProduitDto> findById(@PathVariable Long id) {
        Produit entity = produitService.findById(id);
        ProduitDto customDto = produitMapper.map(entity);
        return ResponseEntity.ok(customDto);
    }


    @GetMapping()
    public ResponseEntity<List<ProduitDto>> findAll() {
        List<Produit> entities = produitService.findAll();
        List<ProduitDto> PDto = produitMapper.map(entities);
        return ResponseEntity.ok(PDto);
    }

    @PostMapping()
    public ResponseEntity<ProduitDto> insert(@RequestBody ProduitDto dto) {
        Produit prod = produitMapper.unMap(dto);
        Produit entity = produitService.insert(prod);
        ProduitDto rdto = produitMapper.map(entity);

        return ResponseEntity.ok(rdto);
    }

    @PutMapping()
    public ResponseEntity<ProduitDto> update(@RequestBody ProduitDto dto) {

        Produit currentProd = produitService.findById(dto.getId());
        produitMapper.updateEntityFromDto(currentProd, dto);
        Produit updatedProd = produitService.update(currentProd);
        ProduitDto responseDto = produitMapper.map(updatedProd);

        return ResponseEntity.ok(responseDto);

    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        produitService.deleteById(id);
    }

}
