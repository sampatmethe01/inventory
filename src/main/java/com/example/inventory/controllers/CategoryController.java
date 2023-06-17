package com.example.inventory.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.inventory.entities.CategoryEntity;
import com.example.inventory.services.CategoryService;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

	@Autowired
	CategoryService categoryService;

	@PostMapping()
	public ResponseEntity<CategoryEntity> saveCategory(@RequestBody CategoryEntity category) {
		return new ResponseEntity<>(categoryService.save(category), HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<CategoryEntity> updateCategory(@PathVariable Integer id,
			@RequestBody CategoryEntity category) {
		return new ResponseEntity<>(categoryService.updateCategory(id, category), HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public ResponseEntity<CategoryEntity> getCategory(@PathVariable Integer id) {
		return new ResponseEntity<CategoryEntity>(categoryService.getCategory(id), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteCategory(@PathVariable Integer id) {
		try {
			return new ResponseEntity<>(categoryService.deleteCategory(id), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
