package com.bolton.esd123grocerystore.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.bolton.esd123grocerystore.models.Product;
import com.bolton.esd123grocerystore.models.User;
import com.bolton.esd123grocerystore.repositories.UserRepository;
import com.bolton.esd123grocerystore.services.CartService;
import com.bolton.esd123grocerystore.services.ProductService;
import com.bolton.esd123grocerystore.services.UserService;




@Controller
@SessionAttributes("products")

public class ProductController {
	@Autowired
	ProductService productService;
	
	@Autowired
	CartService cartService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	UserRepository userRepository;
	
	@GetMapping("/addProduct")
	public String addProductPage() {
		return "addProduct";
	}
	@RequestMapping("/addProduct")
	public String addProduct (@RequestParam String productName, @RequestParam String productDescription, @RequestParam Double productPrice, @RequestParam int productStock) {
		
		Product product = new Product(productName,productDescription,productPrice, productStock);
		productService.addProduct(product);
		return "addProduct";
		
	}
	@RequestMapping(value = "/selectProduct", method = { RequestMethod.GET})
	public String selectProduct(@RequestParam int id, ModelMap model) {
		Product productFound = productService.findProductById(id);
		model.put("product", productFound);
		return "/selectProduct";
		
	}
	@RequestMapping(value = "/searchProduct")
	public String searchProduct(@RequestParam String sName, ModelMap model) {
		Iterable<Product> productFound = productService.findByProductName(sName);
		System.out.println("Product found = " + productFound);
		model.put("product", productFound);
		
		return "/searchProductResults";
		
	}
	
	@GetMapping("/deleteProduct")
	public String deleteProduct(@RequestParam int id, ModelMap model) {
		model.put("product", productService.findProductById(id));
		return "/deleteProduct";
	}
	
	@GetMapping("/reallyDelete")
	public String reallyDelete(@RequestParam int id) {
		productService.deleteProductById(id);
		return "redirect:/productDetails";
	}
	
	
	@GetMapping("/productDetails")
	public String productDetails(ModelMap map) {
		map.put("products", productService.showAllProducts());
		return "productDetails";
	}

	
		
	
	@GetMapping("/home")
	public String productHome(ModelMap map) {
		map.put("products", productService.showAllProducts());
		return "/home";
	}
	
	

}



