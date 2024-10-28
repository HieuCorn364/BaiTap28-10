package com.hieu.ThymleafBT.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.hieu.ThymleafBT.entity.CategoryEntity;
import com.hieu.ThymleafBT.repository.CategoryRepository;
@Service
public class CategoryServiceImpl {
	@Autowired
    private CategoryRepository categoryRepository;

    public Page<CategoryEntity> getCategories(String keyword, int page, int size) {
        if (keyword != null && !keyword.isEmpty()) {
            return categoryRepository.findByNameContaining(keyword, PageRequest.of(page, size));
        }
        return categoryRepository.findAll(PageRequest.of(page, size));
    }
}	
