package com.mathew.customer.service;

import com.mathew.customer.exception.ConflictException;
import com.mathew.customer.model.CreateCustomerRequest;
import com.mathew.customer.repository.CustomerJpaRepository;
import org.springframework.stereotype.Component;

@Component
public class CustomerValidator {
    private final CustomerJpaRepository repository;

    public CustomerValidator(CustomerJpaRepository repository) {
        this.repository = repository;
    }

    public void validate(CreateCustomerRequest request){
        if (repository.existsByCpf(request.cpf())){
            throw new ConflictException("CPF ja cadastrado");
        }
    }
}
