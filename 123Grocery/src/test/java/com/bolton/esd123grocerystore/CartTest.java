package com.bolton.esd123grocerystore;

import static org.junit.Assert.assertTrue;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.bolton.esd123grocerystore.models.Cart;
import com.bolton.esd123grocerystore.models.Product;
import com.bolton.esd123grocerystore.repositories.CartRepository;
import com.bolton.esd123grocerystore.repositories.ProductRepository;
import com.bolton.esd123grocerystore.repositories.UserRepository;
import com.bolton.esd123grocerystore.services.CartService;
import com.bolton.esd123grocerystore.services.ProductService;

@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
@Rollback(false)
public class CartTest {
	
	@Autowired
	private CartRepository cartRepository;
	
	@Autowired
	
	private ProductRepository productRepository;
	
	@Autowired
	
	private UserRepository userRespository;
	
	@Autowired
	private EntityManager entityManager;
	
	private CartService cartService;
	
	private ProductService productService;
	
	@Test
	public void addOneItemToCart() {
		int productId = 1;
		int userId = 1;
		int qty = 10;
		
		Cart cart = new Cart();
		cart.setProductId(productId);
		cart.setUserId(userId);
		cart.setQuantity(qty);
		
		Product product = entityManager.find(Product.class, productId);
		System.out.println("product = " + product);
		double productPrice = product.getProductPrice();
		cart.setSubTotal(productPrice * qty);
		cartRepository.save(cart);
		
		assertTrue(cart.getCartId() > 0);
		
	}
	
	
	

}
