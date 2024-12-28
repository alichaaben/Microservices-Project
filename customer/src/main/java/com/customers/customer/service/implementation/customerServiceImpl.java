package com.customers.customer.service.implementation;

import com.customers.customer.repository.CustomerRepo;
import com.customers.customer.service.CustomerService;
import com.customers.customer.entity.Customer;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class customerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepo customerRepository;

    @Override
    public Customer findById(Long id) {
        return customerRepository.findById(id).orElse(null);
    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Optional<Customer> findByName(String name) {
        return customerRepository.findByName(name);
    }

    @Override
    public Customer insert(Customer Entity) {
        return customerRepository.save(Entity);
    }

    @Override
    public Customer update(Customer Entity) {
        Customer currentCustomer= customerRepository.findById(Entity.getId()).get();
        currentCustomer.setName(Entity.getName());
        currentCustomer.setEmail(Entity.getEmail());
        return customerRepository.save(currentCustomer);
    }

    @Override
    public void deleteById(Long id) {
        customerRepository.deleteById(id);
    }
}
