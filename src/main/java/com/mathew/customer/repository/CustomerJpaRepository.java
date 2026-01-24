package com.mathew.customer.repository;

import com.mathew.customer.model.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerJpaRepository extends JpaRepository<CustomerEntity, Long> {

    boolean existsByCpf(String cpf);
}
