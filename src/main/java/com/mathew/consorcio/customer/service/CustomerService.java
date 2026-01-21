package com.mathew.consorcio.customer.service;

import com.mathew.consorcio.customer.model.Customer;
import com.mathew.consorcio.customer.model.CustomerEntity;
import com.mathew.consorcio.customer.repository.CustomerJpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    private final CustomerJpaRepository repository;

    public CustomerService(CustomerJpaRepository repository){
        this.repository = repository;
    }

    public List<Customer> listCustomers(){
        return repository.findAll()
                .stream()
                .map(this::toDTO)
                .toList();
    }

    public Optional<Customer> getCustomerById(Long id){
        return repository.findById(id)
                .map(this::toDTO);
    }

    private Customer toDTO (CustomerEntity entity){
        return new Customer(entity.getId(),entity.getName());
    }

}
