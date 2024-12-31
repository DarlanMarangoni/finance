package com.darlanmarangoni.financeapi.domain.entities;

import com.darlanmarangoni.financeapi.domain.BankStatementType;
import com.darlanmarangoni.financeapi.domain.dtos.BankStatementDto;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "BANK_STATEMENTS")
public class BankStatementEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bankStatementsSqGen")
    @SequenceGenerator(name = "bankStatementsSqGen", sequenceName = "BANK_STATEMENTS_SEQ", allocationSize = 1)
    @Column(name = "ID", nullable = false)
    private Long id;
    @Column(name = "NAME", nullable = false)
    private String name;
    @Column(name = "DESCRIPTION", nullable = false)
    private String description;
    @Enumerated(EnumType.STRING)
    @Column(name = "BANK_STATEMENT_TYPE", nullable = false)
    private BankStatementType bankStatementType;
    @Column(name = "VALUE", nullable = false)
    private BigDecimal value;
    @Column(name = "PAYMENT_DATE")
    private LocalDate paymentDate;
    @Column(name = "DUE_DATE")
    private LocalDate dueDate;
    @Column(name = "RELEASE_DATE", nullable = false)
    private LocalDate releaseDate;
    @CreationTimestamp
    @Column(name = "CREATED_DATE", nullable = false)
    private LocalDateTime createdDate;
    @UpdateTimestamp
    @Column(name = "UPDATED_DATE", nullable = false)
    private LocalDateTime updatedDate;
    @ManyToOne
    private CategoryEntity category;

    public static BankStatementEntity from(BankStatementDto bankStatementDto) {
        BankStatementEntity entity = new BankStatementEntity();
        entity.name = bankStatementDto.name();
        entity.category = null;
        entity.dueDate = bankStatementDto.dueDate();
        entity.releaseDate = bankStatementDto.releaseDate();
        entity.paymentDate = bankStatementDto.paymentDate();
        entity.value = new BigDecimal(bankStatementDto.value());
        entity.bankStatementType = bankStatementDto.bankStatementType();
        entity.description = bankStatementDto.description();
        return entity;
    }

    public void setCategory(CategoryEntity category) {
        this.category = category;
    }
}
