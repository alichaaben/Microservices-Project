package com.biling.biling.controller;

import com.biling.biling.dto.CustomerDto;
import com.biling.biling.dto.FactureDto;
import com.biling.biling.entity.Facture;
import com.biling.biling.feign.CustomerRestClient;
import com.biling.biling.mapper.FactureMapper;
import com.biling.biling.service.FactureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bill")
public class FactureController {
    @Autowired
    private FactureService factureService;
    @Autowired
    private FactureMapper factureMapper;

    @Autowired
    private CustomerRestClient customerRestClient;

    @GetMapping("/{id}")
    public ResponseEntity<FactureDto> findById(@PathVariable Long id) {
        Facture entity = factureService.findById(id);
        FactureDto FactureDto = factureMapper.map(entity);
        return ResponseEntity.ok(FactureDto);
    }


    @GetMapping()
    public ResponseEntity<List<FactureDto>> findAll() {
        List<Facture> entities = factureService.findAll();
        List<FactureDto> FDto = factureMapper.map(entities);
        return ResponseEntity.ok(FDto);
    }

    @PostMapping()
    public ResponseEntity<FactureDto> insert(@RequestBody FactureDto dto) {
        try {
            // Vérification du Customer via le microservice
            CustomerDto customer = customerRestClient.findCustomerById(dto.getCustomerId());


            Facture entity = factureMapper.unMap(dto);
            entity.setCustomerId(customer.getId());
            entity.setCustomerName(customer.getName());

            Facture savedEntity = factureService.insert(entity);
            FactureDto responseDto = factureMapper.map(savedEntity);

            return ResponseEntity.status(HttpStatus.CREATED).body(responseDto);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @PutMapping()
    public ResponseEntity<FactureDto> update(@RequestBody FactureDto dto) {

        Facture currentFact = factureService.findById(dto.getId());
        factureMapper.updateEntityFromDto(currentFact, dto);
        Facture updatedFact = factureService.update(currentFact);
        FactureDto responseDto = factureMapper.map(updatedFact);

        return ResponseEntity.ok(responseDto);

    }

//    @PutMapping("/{id}")
//    public ResponseEntity<FactureDto> update(@PathVariable Long id, @RequestBody FactureDto dto) {
//        try {
//            Facture currentFact = factureService.findById(id);
//            if (currentFact == null) {
//                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
//            }
//
//            // Vérification du Customer via le microservice
//            CustomerDto customer = customerRestClient.findCustomerById(dto.getCustomerId());
//            if (customer == null) {
//                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
//                        .body(null); // Customer inexistant
//            }
//
//            currentFact.setCustomerId(customer.getId()); // Mise à jour avec Customer valide
//            factureMapper.updateEntityFromDto(currentFact, dto);
//            Facture updatedFact = factureService.update(currentFact);
//            FactureDto responseDto = factureMapper.map(updatedFact);
//
//            return ResponseEntity.ok(responseDto);
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
//        }
//    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        factureService.deleteById(id);
    }

}
