package com.bolton.esd123grocerystore.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.bolton.esd123grocerystore.models.Product;
import com.bolton.esd123grocerystore.repositories.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {
	
	private ProductRepository productRepository;
	
	public ProductServiceImpl (ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	@Override
	public Product addProduct(Product product) {
		return this.productRepository.save(product);
	}

	@Override
	public Product findProductById(int Id) {
		Optional<Product> product = productRepository.findById(Id);
		Product foundProduct = new Product(product.get().getProductId(), product.get().getProductName(), product.get().getProductDescription(), product.get().getProductPrice(),product.get().getProductStock());
		System.out.println("Product = " + product);
		System.out.println("Found Product = " + foundProduct);
		return foundProduct;
	}

	@Override
	public void deleteProductById(int Id) {
		System.out.println("Product ID = " + Id);
		Optional<Product> product = productRepository.findById(Id);
		System.out.println("Product = " + product);
		//productRepository.deleteById(Id);
		productRepository.delete(product.get());
	}

	@Override
	public Object showAllProducts() {
		Iterable<Product> products = productRepository.findAll();
		return products;
	}

	@Override
	public Iterable<Product> findByProductName(String sName) {
		Iterable<Product> products = productRepository.findByNameIgnoreCase(sName);
		System.out.println (products);
		return products;
	}

	@Override
	public void removeOneFromStockLevel(int Id) {
		Optional<Product> product = productRepository.findById(Id);
		Product updatedProduct = product.get();
		updatedProduct.setProductStock(updatedProduct.getProductStock() - 1);
		productRepository.save(updatedProduct);
	}

}
