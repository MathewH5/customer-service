package com.mathew.consorcio.customer.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record CustomerResponse(
        Long id,
        String name,
        String email,
        String phoneNumber,
        LocalDate brithDate,
        String cpf,
        LocalDateTime createdAt
        ) {
}
