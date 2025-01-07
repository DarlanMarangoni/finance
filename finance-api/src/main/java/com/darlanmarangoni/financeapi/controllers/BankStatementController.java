package com.darlanmarangoni.financeapi.controllers;

import com.darlanmarangoni.financeapi.domain.BankStatementType;
import com.darlanmarangoni.financeapi.domain.dtos.BankStatementDto;
import com.darlanmarangoni.financeapi.domain.entities.BankStatementEntity;
import com.darlanmarangoni.financeapi.domain.entities.CategoryEntity;
import com.darlanmarangoni.financeapi.exceptions.NotFoundException;
import com.darlanmarangoni.financeapi.services.BankStatementService;
import com.darlanmarangoni.financeapi.services.CategoryService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class BankStatementController {

    private final CategoryService categoryService;

    private final BankStatementService bankStatementService;

    public BankStatementController(final CategoryService categoryService,
                                   final BankStatementService bankStatementService) {
        this.categoryService = categoryService;
        this.bankStatementService = bankStatementService;
    }

    @GetMapping("/bankStatement")
    public String bankStatement(@PageableDefault(page = 0, size = 7, sort = "releaseDate", direction = Sort.Direction.DESC) final Pageable pageable,
                                final Model model) {
        final List<CategoryEntity> categories = categoryService.findAll();
        final Page<BankStatementEntity> releases = bankStatementService.findByReleaseDate(pageable);
        model.addAttribute("message", "Lançamentos de receitas e despesas");
        model.addAttribute("bankStatementTypes", BankStatementType.values());
        model.addAttribute("categories", categories);
        model.addAttribute("bankStatementDto", new BankStatementDto());
        model.addAttribute("releases", releases.getContent());
        return "bankStatement";
    }

    @PostMapping("/bankStatement")
    public String create(@ModelAttribute final BankStatementDto dto, final Model model) {
        Optional<CategoryEntity> opt = categoryService.findById(dto.getCategorie());
        if (opt.isEmpty()) {
            throw new NotFoundException("Category not exists");
        }
        BankStatementEntity entity = BankStatementEntity.from(dto);
        entity.setCategory(opt.get());
        bankStatementService.save(entity);
        return "redirect:/bankStatement";
    }
}
