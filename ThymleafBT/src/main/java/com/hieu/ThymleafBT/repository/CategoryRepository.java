package com.hieu.ThymleafBT.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import com.hieu.ThymleafBT.entity.CategoryEntity;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {
	Page<CategoryEntity> findByCatenameContaining(String keyword, PageRequest of);
}

