package com.example.inventory.services;

import com.example.inventory.entities.CategoryEntity;

public interface CategoryService {

	public CategoryEntity save(CategoryEntity entity);

	public CategoryEntity getCategory(Integer id);

	public CategoryEntity updateCategory(Integer id, CategoryEntity entity);

	public String deleteCategory(Integer id) throws Exception;
}
