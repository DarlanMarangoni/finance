package com.darlanmarangoni.financeapi.resources;

import com.darlanmarangoni.financeapi.domain.dtos.BankStatementDto;
import com.darlanmarangoni.financeapi.domain.entities.BankStatementEntity;
import com.darlanmarangoni.financeapi.domain.entities.CategoryEntity;
import com.darlanmarangoni.financeapi.repositories.BankStatementRepository;
import com.darlanmarangoni.financeapi.repositories.CategoryRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.Optional;

@RestController
@RequestMapping("/bank-statements")
public class BankStatementResource {

    private final BankStatementRepository bankStatementRepository;

    private final CategoryRepository categoryRepository;

    public BankStatementResource(BankStatementRepository bankStatementRepository, CategoryRepository categoryRepository) {
        this.bankStatementRepository = bankStatementRepository;
        this.categoryRepository = categoryRepository;
    }

    @PostMapping
    public ResponseEntity<Void> createUser(@RequestBody BankStatementDto bankStatementDto) {
        Optional<CategoryEntity> opt = categoryRepository.findByName(bankStatementDto.getCategorie());
        if (opt.isEmpty()) {
            throw new RuntimeException("Category not exists");
        }
        BankStatementEntity entity = BankStatementEntity.from(bankStatementDto);
        entity.setCategory(opt.get());
        return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(bankStatementRepository.save(entity)).toUri()).build();
    }

}
