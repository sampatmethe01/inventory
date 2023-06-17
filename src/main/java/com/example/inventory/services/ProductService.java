package com.example.inventory.services;

import com.example.inventory.entities.ProductEntity;

public interface ProductService {

	public ProductEntity saveProduct(ProductEntity entity);
	
	public ProductEntity getProduct(Integer id);
	
	public ProductEntity updateProduct(Integer id, ProductEntity entity);
	
	public String deleteProduct(Integer id) throws Exception;
	
	
}
