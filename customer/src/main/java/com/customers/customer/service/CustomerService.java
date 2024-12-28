package com.customers.customer.service;

import com.customers.customer.entity.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    Customer findById(Long id);

    List<Customer> findAll();

    Optional<Customer> findByName(String name);

    Customer insert(Customer Entity);

    Customer update(Customer Entity);

    void deleteById(Long id);
}
