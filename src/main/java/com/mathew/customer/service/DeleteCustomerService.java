package com.mathew.customer.service;

import com.mathew.customer.exception.CustomerNotFoundException;
import com.mathew.customer.model.CustomerEntity;
import com.mathew.customer.repository.CustomerJpaRepository;
import org.springframework.stereotype.Service;

@Service
public class DeleteCustomerService {
    private final CustomerJpaRepository repository;

    public DeleteCustomerService(CustomerJpaRepository repository) {
        this.repository = repository;
    }

    public void execute (Long id){
        CustomerEntity entity = repository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException(id));

        repository.delete(entity);
    }
}
