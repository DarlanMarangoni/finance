package com.darlanmarangoni.financeapi.controllers;

import com.darlanmarangoni.financeapi.domain.BankStatementType;
import com.darlanmarangoni.financeapi.domain.dtos.BankStatementDto;
import com.darlanmarangoni.financeapi.domain.entities.CategoryEntity;
import com.darlanmarangoni.financeapi.repositories.CategoryRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class BankStatementController {

    private final CategoryRepository categoryRepository;

    public BankStatementController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @GetMapping("/bankStatement")
    public String bankStatement(Model model) {
        final List<CategoryEntity> categories = categoryRepository.findAll();
        model.addAttribute("message", "Lançamentos de receitas e despesas");
        model.addAttribute("bankStatementTypes", BankStatementType.values());
        model.addAttribute("categories", categories);
        model.addAttribute("bankStatementDto", new BankStatementDto());
        return "bankStatement";
    }

    @PostMapping("/bankStatement")
    public String create(@ModelAttribute BankStatementDto dto, Model model) {
        System.out.println(dto);
        return "bankStatement";
    }
}
