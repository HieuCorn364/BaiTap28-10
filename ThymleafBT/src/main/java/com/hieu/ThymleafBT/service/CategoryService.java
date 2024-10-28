package com.hieu.ThymleafBT.service;

import org.springframework.data.domain.Page;

import com.hieu.ThymleafBT.entity.CategoryEntity;

public interface CategoryService {

	Page<CategoryEntity> getCategories(String keyword, int page, int size);
	
}
