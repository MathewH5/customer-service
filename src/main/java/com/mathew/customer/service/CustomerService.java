package com.mathew.customer.service;

import com.mathew.customer.model.CustomerResponse;
import com.mathew.customer.model.CustomerEntity;
import com.mathew.customer.repository.CustomerJpaRepository;
import com.mathew.customer.service.mapper.CustomerMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    private final CustomerJpaRepository repository;
    private final CustomerMapper mapper;

    public CustomerService(CustomerJpaRepository repository, CustomerMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<CustomerResponse> getCustomers(){
        return repository.findAll()
                .stream()
                .map(this::toDTO)
                .toList();
    }

    public Optional<CustomerResponse> getCustomerById(Long id){
        return repository.findById(id)
                .map(this::toDTO);
    }

    private CustomerResponse toDTO(CustomerEntity entity){
        return mapper.toResponse(entity);
    }


}
