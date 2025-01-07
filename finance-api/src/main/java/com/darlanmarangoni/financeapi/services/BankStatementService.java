package com.darlanmarangoni.financeapi.services;

import com.darlanmarangoni.financeapi.domain.entities.BankStatementEntity;
import com.darlanmarangoni.financeapi.repositories.BankStatementRepository;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class BankStatementService {

    private final BankStatementRepository bankStatementRepository;

    public BankStatementService(BankStatementRepository bankStatementRepository) {
        this.bankStatementRepository = bankStatementRepository;
    }

    @Transactional
    public void save(final BankStatementEntity entity) {
        bankStatementRepository.save(entity);
    }

    public Page<BankStatementEntity> findByReleaseDate(Pageable pageable) {
        return bankStatementRepository.findAll(pageable);
    }
}
