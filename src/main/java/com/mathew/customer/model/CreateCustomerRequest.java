package com.mathew.customer.model;

import java.time.LocalDate;

public record CreateCustomerRequest(
        String name,
        String email,
        String phoneNumber,
        LocalDate birthDate,
        String cpf
) {}
