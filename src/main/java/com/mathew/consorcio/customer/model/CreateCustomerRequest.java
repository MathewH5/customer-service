package com.mathew.consorcio.customer.model;

import java.time.LocalDate;

public record CreateCustomerRequest(
        String name,
        String email,
        String phoneNumber,
        LocalDate brithDate,
        String cpf
) {}
