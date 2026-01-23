package com.mathew.consorcio.customer.repository;

import com.mathew.consorcio.customer.model.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerJpaRepository extends JpaRepository<CustomerEntity, Long> {

    boolean existsByCpf(String cpf);
}
