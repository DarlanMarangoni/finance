package com.darlanmarangoni.financeapi.domain.dtos;

import com.darlanmarangoni.financeapi.domain.BankStatementType;

import java.time.LocalDate;

public class BankStatementDto {
    private String categorie;
    private String name;
    private String value;
    private LocalDate releaseDate;
    private LocalDate dueDate;
    private LocalDate paymentDate;
    private String description;
    private BankStatementType bankStatementType;

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BankStatementType getBankStatementType() {
        return bankStatementType;
    }

    public void setBankStatementType(BankStatementType bankStatementType) {
        this.bankStatementType = bankStatementType;
    }

    @Override
    public String toString() {
        return "BankStatementDto{" +
                "categorie='" + categorie + '\'' +
                ", name='" + name + '\'' +
                ", value='" + value + '\'' +
                ", releaseDate=" + releaseDate +
                ", dueDate=" + dueDate +
                ", paymentDate=" + paymentDate +
                ", description='" + description + '\'' +
                ", bankStatementType=" + bankStatementType +
                '}';
    }
}
