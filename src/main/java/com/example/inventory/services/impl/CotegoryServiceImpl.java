package com.example.inventory.services.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.inventory.entities.CategoryEntity;
import com.example.inventory.repositories.CategoryRepository;
import com.example.inventory.services.CategoryService;

@Service
public class CotegoryServiceImpl implements CategoryService {

	@Autowired
	CategoryRepository categoryRepository;

	@Override
	public CategoryEntity save(CategoryEntity entity) {
		return categoryRepository.save(entity);
	}

	@Override
	public CategoryEntity getCategory(Integer id) {
		return categoryRepository.findById(id).get();
	}

	@Override
	public CategoryEntity updateCategory(Integer id, CategoryEntity entity) {
		Optional<CategoryEntity> updateEntity = categoryRepository.findById(id);
		if (updateEntity.isPresent()) {
			updateEntity.get().setName(entity.getName());
			return categoryRepository.save(updateEntity.get());
		}
		return null;
	}

	@Override
	public String deleteCategory(Integer id) throws Exception {
		categoryRepository.deleteById(id);
		return "Category deleted successfully";
	}

}
