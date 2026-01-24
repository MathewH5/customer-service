package com.mathew.customer.model;

import java.time.LocalDate;

public record UpdateCustomerRequest(
        String name,
        String email,
        String phoneNumber,
        LocalDate birthDate
) {}