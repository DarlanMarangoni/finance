package com.darlanmarangoni.financeapi.domain.dtos;

import java.util.UUID;

public record UserDto(
        UUID id,
        String name,
        String email
) {}
