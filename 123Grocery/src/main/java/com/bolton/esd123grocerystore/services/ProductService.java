package com.bolton.esd123grocerystore.services;

import org.springframework.stereotype.Service;

import com.bolton.esd123grocerystore.models.Product;


@Service
public interface ProductService {

	Product addProduct(Product product);
	
	Product findProductById(int Id);
	
	void deleteProductById(int id);

	Object showAllProducts();

	Iterable<Product> findByProductName(String sName);
	
 
}
