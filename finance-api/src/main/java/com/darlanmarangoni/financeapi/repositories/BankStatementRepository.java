package com.darlanmarangoni.financeapi.repositories;

import com.darlanmarangoni.financeapi.domain.entities.BankStatementEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface BankStatementRepository extends JpaRepository<BankStatementEntity, Long> {

    Page<BankStatementEntity> findAll(Pageable pageable);

}
