package com.mathew.customer.model;

import java.time.LocalDate;

public record CustomerRequest(
        String name,
        String email,
        String phoneNumber,
        LocalDate brithDate,
        String cpf
) {}
