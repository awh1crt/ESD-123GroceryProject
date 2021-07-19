package com.bolton.esd123grocerystore.controllers;

import java.util.ArrayList;
import java.util.HashMap;
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
		User foundUser = userService.findUserByEMail(user);
		int foundUserId = foundUser.getUserId();
		List<Cart> cart = cartRepository.findByUserId(foundUserId);
		int i = 0;
		List<Product> products = new ArrayList<>();
		while (i < cart.size()) {
			//System.out.println("product list " + cart.get(i));
			int foundProductId = cart.get(i).getProductId();
			System.out.println("productId = " + foundProductId);
			products.add(i, productRepository.getById(foundProductId));
			System.out.println("Products " + products.get(i));
			
			i++;
		}
		
		((HashMap<String, Object>) model).put("cart", cart);
		((HashMap<String, Object>) model).put("products", products);
		System.out.println("Cart items = " + cart);
		System.out.println("Products = " + products);
		
		
		return("/cart");
	
	}
	
	@GetMapping("/buyProduct")
	public String addProductToCart(@RequestParam int productId,@ModelAttribute("userName") String user ) {
		int quantity = 1;
		System.out.println("user = " + user);
		User userDetails = userRepository.findByUserEmail(user);
		System.out.println("user details = " + userDetails);
		int userId = userDetails.getUserId();
		Cart cartDetails = cartService.addItemstoCartByProductAndQuantityAndUser(productId, quantity, userId);
		int cartId = cartDetails.getCartId();
		cartProductsService.addProducts(cartId, productId);
		
		
		
		
		
		return "/addToCartSuccess";
		
		
	}

}
