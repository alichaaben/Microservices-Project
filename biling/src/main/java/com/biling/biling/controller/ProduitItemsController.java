package com.biling.biling.controller;

import com.biling.biling.dto.ProduitItemsDto;
import com.biling.biling.entity.ProduitItems;
import com.biling.biling.mapper.ProduitItemsMapper;
import com.biling.biling.service.ProduitItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/ProduitItems")
public class ProduitItemsController {
    @Autowired
    private ProduitItemsService produitItemsService;
    @Autowired
    private ProduitItemsMapper produitItemsMapper;

    @GetMapping("/{id}")
    public ResponseEntity<ProduitItemsDto> findById(@PathVariable Long id) {
        ProduitItems entity = produitItemsService.findById(id);
        ProduitItemsDto ProdItemsDto = produitItemsMapper.map(entity);
        return ResponseEntity.ok(ProdItemsDto);
    }


    @GetMapping()
    public ResponseEntity<List<ProduitItemsDto>> findAll() {
        List<ProduitItems> entities = produitItemsService.findAll();
        List<ProduitItemsDto> PDto = produitItemsMapper.map(entities);
        return ResponseEntity.ok(PDto);
    }

    @PostMapping()
    public ResponseEntity<ProduitItemsDto> insert(@RequestBody ProduitItemsDto dto) {
        ProduitItems prod = produitItemsMapper.unMap(dto);
        ProduitItems entity = produitItemsService.insert(prod);
        ProduitItemsDto rdto = produitItemsMapper.map(entity);

        return ResponseEntity.ok(rdto);
    }

    @PutMapping()
    public ResponseEntity<ProduitItemsDto> update(@RequestBody ProduitItemsDto dto) {

        ProduitItems currentProdItems = produitItemsService.findById(dto.getId());
        produitItemsMapper.updateEntityFromDto(currentProdItems, dto);
        ProduitItems updatedProdItems = produitItemsService.update(currentProdItems);
        ProduitItemsDto responseDto = produitItemsMapper.map(updatedProdItems);

        return ResponseEntity.ok(responseDto);

    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        produitItemsService.deleteById(id);
    }

}
