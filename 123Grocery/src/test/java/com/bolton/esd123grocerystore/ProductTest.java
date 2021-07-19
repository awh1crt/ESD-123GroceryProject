package com.bolton.esd123grocerystore;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.bolton.esd123grocerystore.models.Product;
import com.bolton.esd123grocerystore.repositories.ProductRepository;
import com.bolton.esd123grocerystore.services.ProductService;

@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
@Rollback(false)
public class ProductTest {
	@Autowired
	ProductRepository productRepository;
	@Autowired
	EntityManager entityManager;
	
	private ProductService productService;
	

	
	@Test
	public void addNewProduct() {
		
		Product newProduct = new Product();
		newProduct.setProductName("Apple");
		newProduct.setProductDescription("Fruit");
		newProduct.setProductStock(100);
		newProduct.setProductPrice(0.50);
		System.out.println("new Product = " + newProduct);
		
		Product savedProduct = productRepository.save(newProduct);
		
		System.out.println("save Product = " + savedProduct);
		
		Product existProduct = entityManager.find(Product.class, savedProduct.getProductId());
		assertThat(existProduct.getProductName().equals(savedProduct.getProductName()));
		
		
	}
	
	@Test
	public void addSecondNewProduct() {
		Product newProduct = new Product();
		newProduct.setProductName("Egg");
		newProduct.setProductDescription("Hens Egg");
		newProduct.setProductStock(200);
		newProduct.setProductPrice(0.10);
		System.out.println("new Product = " + newProduct);
		
		Product savedProduct = productRepository.save(newProduct);
		
		System.out.println("save Product = " + savedProduct);
		
		Product existProduct = entityManager.find(Product.class, savedProduct.getProductId());
		assertThat(existProduct.getProductName().equals(savedProduct.getProductName()));
		
	}
	
	@Test
	public void deleteProductById() {
		
		int productId = 4;
		Product savedProduct = productRepository.getById(productId);
		System.out.println("save Product = " + savedProduct);
		assertThat(savedProduct.getProductId()== 4);
		productRepository.deleteById(productId);
		System.out.println("get product id = " + savedProduct.getProductId());
		//productService.findProductById(savedProduct.getProductId());
		//productService.deleteProductById(savedProduct.getProductId());
		Long rowCount = productRepository.count();
		System.out.println("row count = " + rowCount);
		assertEquals(3,rowCount);

	}
	@Test
	public void updateProductPrice() {
		int productId = 1;
		Product savedProduct = productRepository.getById(productId);
		System.out.println("save Product = " + savedProduct);
		assertThat(savedProduct.getProductId()== 1);
		assertThat(savedProduct.getProductPrice()== 0.50);

		savedProduct.setProductPrice(0.10);
		Product updatedProduct = productRepository.save(savedProduct);
		assertThat(updatedProduct.getProductPrice().equals(savedProduct.getProductPrice()));
	}
	
	@Test
	public void findProductByName() {
		String productName="tv";
		System.out.println(productRepository.findByNameIgnoreCase(productName));
		
		
	}
	@Test
	public void decreaseStockLevel() {
		int productId = 1;
		Product product = productRepository.getById(productId);
		System.out.println("save Product = " + product);
		int currentStock = product.getProductStock();
		System.out.println("Current Stock = " + currentStock);
		int newStock = currentStock - 10;
		product.setProductStock(newStock);
		Product updatedProduct = productRepository.save(product);
		System.out.println("new Stock = " + newStock);
		System.out.println("Updated Product details = " + updatedProduct);
		
		
		
		

		
	}

}
