package com.mathew.customer.service;

import com.mathew.customer.model.CustomerRequest;
import com.mathew.customer.model.CustomerEntity;
import com.mathew.customer.model.CustomerResponse;
import com.mathew.customer.repository.CustomerJpaRepository;
import com.mathew.customer.service.mapper.CustomerMapper;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class CreateCustomerService {

    private final CustomerJpaRepository repository;
    private final CustomerMapper mapper;
    private final CustomerValidator validator;

    public CreateCustomerService(CustomerJpaRepository repository, CustomerMapper mapper, CustomerValidator validator) {
        this.repository = repository;
        this.mapper = mapper;
        this.validator = validator;
    }

    @Transactional
    public CustomerResponse execute(CustomerRequest request) {
        validator.validate(request);

        CustomerEntity entity = mapper.toEntity(request);
        CustomerEntity saved = repository.save(entity);

        return mapper.toResponse(saved);
    }
}
