package com.darlanmarangoni.financeapi.repositories;

import com.darlanmarangoni.financeapi.domain.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public interface UserRepository extends JpaRepository<UserEntity, UUID> {}
