package com.bolton.esd123grocerystore.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.bolton.esd123grocerystore.models.Cart;
import com.bolton.esd123grocerystore.models.CartProducts;
import com.bolton.esd123grocerystore.models.Product;
import com.bolton.esd123grocerystore.models.User;
import com.bolton.esd123grocerystore.repositories.CartProductsRepository;
import com.bolton.esd123grocerystore.repositories.CartRepository;
import com.bolton.esd123grocerystore.repositories.ProductRepository;
import com.bolton.esd123grocerystore.repositories.UserRepository;
import com.bolton.esd123grocerystore.services.CartProductsService;
import com.bolton.esd123grocerystore.services.CartService;
import com.bolton.esd123grocerystore.services.ProductService;
import com.bolton.esd123grocerystore.services.UserService;


@Controller
@SessionAttributes("userName")


public class CartController {
	
	@Autowired 
	CartService cartService;
	
	@Autowired
	CartRepository cartRepository;
	
	@Autowired
	ProductRepository productRepository;
	@Autowired
	ProductService productService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	CartProductsRepository cartProductsRepository;
	@Autowired
	CartProductsService cartProductsService;
	
	
	@RequestMapping(value = "/cart", method = { RequestMethod.GET})
	public String showCart(Model model, @ModelAttribute("userName") String user){
		double total = 0;
		User foundUser = userService.findUserByEMail(user);
		int foundUserId = foundUser.getUserId();
		List<CartProducts> cartProducts = cartProductsRepository.findByUserId(foundUserId);
		((HashMap<String, Object>) model).put("cart", cartProducts);
		
		return("/cart");
	
	}
	
	@GetMapping("/buyProduct")
	public String addProductToCart(@RequestParam int productId,@ModelAttribute("userName") String user ) {
		int quantity = 1;
		System.out.println("user = " + user);
		User userDetails = userRepository.findByUserEmail(user);
		System.out.println("user details = " + userDetails);
		int userId = userDetails.getUserId();
		System.out.println("USer id = " + userId);
		System.out.println("product id = "+ productId);
		boolean exists  = cartRepository.existsByUserIdAndProductId(userId, productId);
		if (exists) {
			Cart cartToUpdateId =  cartRepository.getByUserIdAndProductId(userId, productId);
			cartToUpdateId.setQuantity(cartToUpdateId.getQuantity() + 1);
			cartRepository.save(cartToUpdateId);
			cartProductsService.updateQuantityByOne(cartToUpdateId.getCartId());
			productService.removeOneFromStockLevel(productId);
//			double totalPrice = cartProductsRepository.calculateCartTotalForUser(userId);
//			System.out.println("tota price = " + totalPrice);
		} else {
		
			Cart cartDetails = cartService.addItemstoCartByProductAndQuantityAndUser(productId, quantity, userId);
			int cartId = cartDetails.getCartId();
			int userId1 = userDetails.getUserId();
			cartProductsService.addProducts(cartId, productId, quantity, userId1);
			productService.removeOneFromStockLevel(productId);

		}
		
		
		
		
		return "/addToCartSuccess";
		
		
	}

}
