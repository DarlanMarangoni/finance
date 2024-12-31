package com.darlanmarangoni.financeapi.domain.entities;

import com.darlanmarangoni.financeapi.domain.BankStatementType;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;

@Entity
@Table(name = "BANK_STATEMENTS")
public class BankStatementEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
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
    @CreationTimestamp
    @Column(name = "CREATED_DATE", nullable = false)
    private String createdDate;
    @UpdateTimestamp
    @Column(name = "UPDATED_DATE", nullable = false)
    private String updatedDate;
    @ManyToOne
    private CategoryEntity category;
}
