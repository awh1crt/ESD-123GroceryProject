package com.bolton.esd123grocerystore;

import static org.junit.Assert.assertTrue;

import java.util.List;

import static org.junit.Assert.assertEquals;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.bolton.esd123grocerystore.models.Product;
import com.bolton.esd123grocerystore.models.User;
import com.bolton.esd123grocerystore.repositories.ProductRepository;
import com.bolton.esd123grocerystore.repositories.UserRepository;
import com.bolton.esd123grocerystore.services.ProductService;

import backups.oldclasses.CartItem;
import backups.oldclasses.CartItemRepository;
import backups.oldclasses.CartItemService;



@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
@Rollback(false)

public class CartItemTest {
	
	@Autowired
	private CartItemRepository cartItemRepository;
	
		@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private EntityManager entityManager;
	
	private CartItemService cartItemService;
	
	private ProductService productService;
	
	@Test
	public void addOneCartItem() {
		
    	Product product = entityManager.find(Product.class, 1);
    	User user = entityManager.find(User.class, 2);

		System.out.println(product);
		System.out.println(user);
		
		CartItem newCartItem = new CartItem();
		newCartItem.setProduct(product);
		newCartItem.setUser(user);
		newCartItem.setQuantity(50);
		
		System.out.println(newCartItem);
		
		cartItemRepository.save(newCartItem);
		
		assertTrue(newCartItem.getCartItemId() > 0);
		
		
		
		
	}
	@Test
	public void addItemToCart() {
		int productId = 6;
		int quantity = 10;
		System.out.println("Product ID = " + productId);
		System.out.println("Quantity = " + quantity);
		Product product = productService.findProductById(productId);
		System.out.println("PRoduct = " + product);
		CartItem cartItem = cartItemService.addCartItems(productId, quantity);
		cartItemRepository.save(cartItem);
		System.out.println ("Cart Item = " + cartItem);
		
		
	}
	@Test
	public void findByUser() {
		User user = new User();
		user.setUserId(1);
		System.out.println(user);
		
		List<CartItem> cartItems = cartItemRepository.findByUser(user);
		System.out.println("Cart Items = " + cartItems);
		assertEquals(1, cartItems.size());
	}

}

