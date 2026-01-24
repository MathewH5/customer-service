package com.mathew.customer.service;

import com.mathew.customer.exception.CustomerNotFoundException;
import com.mathew.customer.model.CustomerEntity;
import com.mathew.customer.model.CustomerRequest;
import com.mathew.customer.model.CustomerResponse;
import com.mathew.customer.repository.CustomerJpaRepository;
import com.mathew.customer.service.mapper.CustomerMapper;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UpdateCustomerService {
    private final CustomerMapper mapper;
    private final CustomerJpaRepository repository;

    public UpdateCustomerService(CustomerMapper mapper, CustomerJpaRepository repository) {
        this.mapper = mapper;
        this.repository = repository;
    }

    @Transactional
    public CustomerResponse execute (Long id, CustomerRequest request){
        CustomerEntity entity = repository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException(id));

        entity.setName(request.name());
        entity.setEmail(request.email());
        entity.setBirthDate(request.brithDate());
        entity.setPhoneNumber(request.phoneNumber());

        CustomerEntity saved = repository.save(entity);

        return mapper.toResponse(saved);
    }

}
