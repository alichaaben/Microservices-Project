package com.customers.customer.controller;

import com.customers.customer.service.CustomerService;
import com.customers.customer.dto.CustomerDto;
import com.customers.customer.entity.Customer;
import com.customers.customer.mapper.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;




@RestController
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private   CustomerMapper customerMapper;

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDto> findById(@PathVariable Long id) {
        Customer entity = customerService.findById(id);
        CustomerDto customDto = customerMapper.map(entity);
        return ResponseEntity.ok(customDto);
    }


    @GetMapping()
    public ResponseEntity<List<CustomerDto>> findAll() {
        List<Customer> entities = customerService.findAll();
        List<CustomerDto> customDto = customerMapper.map(entities);
        return ResponseEntity.ok(customDto);
    }

    @PostMapping()
    public ResponseEntity<CustomerDto> insert(@RequestBody CustomerDto dto) {
        Customer custom = customerMapper.unMap(dto);
        Customer entity = customerService.insert(custom);
        CustomerDto rdto = customerMapper.map(entity);

        return ResponseEntity.ok(rdto);
    }

    @PutMapping()
    public ResponseEntity<CustomerDto> update(@RequestBody CustomerDto dto) {

        Customer currentCustomer = customerService.findById(dto.getId());
        customerMapper.updateEntityFromDto(currentCustomer, dto);
        Customer updatedCustomer = customerService.update(currentCustomer);
        CustomerDto responseDto = customerMapper.map(updatedCustomer);

        return ResponseEntity.ok(responseDto);

    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        customerService.deleteById(id);
    }

}
