package com.darlanmarangoni.financeapi.domain.dtos;

import com.darlanmarangoni.financeapi.domain.BankStatementType;

import java.time.LocalDate;

public record BankStatementDto(
        String categorie,
        String name,
        String value,
        LocalDate releaseDate,
        LocalDate dueDate,
        LocalDate paymentDate,
        String description,
        BankStatementType bankStatementType
) {}
