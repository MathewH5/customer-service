package com.mathew.consorcio.customer.service;

import com.mathew.consorcio.customer.model.CreateCustomerRequest;
import com.mathew.consorcio.customer.model.CustomerResponse;
import com.mathew.consorcio.customer.model.CustomerEntity;
import com.mathew.consorcio.customer.repository.CustomerJpaRepository;
import com.mathew.consorcio.customer.service.mapper.CustomerMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    private final CustomerJpaRepository repository;
    private final CustomerMapper mapper;

    public CustomerService(CustomerJpaRepository repository, CustomerMapper mapper){
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

    public CustomerResponse createCustomer (CreateCustomerRequest request){
        CustomerEntity entity = mapper.toEntity(request);
        CustomerEntity saved = repository.save(entity);

        return mapper.toResponse(saved);
    }
}
