package com.darlanmarangoni.financeapi.resources;

import com.darlanmarangoni.financeapi.domain.dtos.CategoryDto;
import com.darlanmarangoni.financeapi.domain.entities.CategoryEntity;
import com.darlanmarangoni.financeapi.repositories.CategoryRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryResource {

    private final CategoryRepository categoryRepository;

    public CategoryResource(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @PostMapping
    public ResponseEntity<Void> createCategory(@RequestBody CategoryDto dto) {
        var category = categoryRepository.save(new CategoryEntity(dto.name()));
        return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(category.getId()).toUri()).build();
    }

    @GetMapping
    public ResponseEntity<List<CategoryDto>> getAllCategories() {
        return ResponseEntity.ok(categoryRepository.findAll()
                .stream()
                .map(m -> new CategoryDto(m.getId(), m.getName()))
                .toList());
    }

}