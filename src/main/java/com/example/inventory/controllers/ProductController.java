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

import com.example.inventory.entities.ProductEntity;
import com.example.inventory.services.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {

	@Autowired
	ProductService productService;

	@PostMapping()
	public ResponseEntity<ProductEntity> saveProduct(@RequestBody ProductEntity product) {
		return new ResponseEntity<ProductEntity>(productService.saveProduct(product), HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<ProductEntity> updateProduct(@PathVariable Integer id, @RequestBody ProductEntity product) {
		return new ResponseEntity<ProductEntity>(productService.updateProduct(id, product), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<ProductEntity> getProduct(@PathVariable Integer id) {
		return new ResponseEntity<ProductEntity>(productService.getProduct(id), HttpStatus.OK);
	}

	@DeleteMapping()
	public ResponseEntity<String> deleteProduct(@PathVariable Integer id) {
		try {
			return new ResponseEntity<>(productService.deleteProduct(id), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("Invalid product id", HttpStatus.BAD_REQUEST);
		}

	}
}
