package com.example.inventory.services.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.inventory.entities.ProductEntity;
import com.example.inventory.repositories.ProductRepository;
import com.example.inventory.services.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository productRepository;

	@Override
	public ProductEntity saveProduct(ProductEntity entity) {
		return productRepository.save(entity);
	}

	@Override
	public ProductEntity getProduct(Integer id) {
		return productRepository.findById(id).get();
	}

	@Override
	public ProductEntity updateProduct(Integer id, ProductEntity entity) {
		Optional<ProductEntity> updateProduct = productRepository.findById(id);
		if (updateProduct.isEmpty()) {
			updateProduct.get().setName(entity.getName());
			updateProduct.get().setCategory(entity.getCategory());
			return productRepository.save(entity);
		}
		return null;
	}

	@Override
	public String deleteProduct(Integer id) throws Exception {
		productRepository.deleteById(id);
		return "Product deleted successfully!";
	}

}
