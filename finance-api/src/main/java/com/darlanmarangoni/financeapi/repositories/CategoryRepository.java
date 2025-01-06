package com.darlanmarangoni.financeapi.repositories;

import com.darlanmarangoni.financeapi.domain.entities.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {
    List<CategoryEntity> findByOrderByNameAsc();
}
