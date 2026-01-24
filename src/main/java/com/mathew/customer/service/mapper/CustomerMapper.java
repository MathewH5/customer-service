package com.mathew.customer.service.mapper;

import com.mathew.customer.model.CustomerRequest;
import com.mathew.customer.model.CustomerEntity;
import com.mathew.customer.model.CustomerResponse;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {
    public CustomerEntity toEntity(CustomerRequest request){
        CustomerEntity entity = new CustomerEntity();
        entity.setName(request.name());
        entity.setEmail(request.email());
        entity.setPhoneNumber(request.phoneNumber());
        entity.setCpf(request.cpf());
        entity.setBirthDate(request.brithDate());
        return entity;
    }

    public CustomerResponse toResponse(CustomerEntity entity){
        return new CustomerResponse(
                entity.getId(),
                entity.getName(),
                entity.getEmail(),
                entity.getPhoneNumber(),
                entity.getBirthDate(),
                entity.getCpf(),
                entity.getCreatedAt()
        );
    }
}
