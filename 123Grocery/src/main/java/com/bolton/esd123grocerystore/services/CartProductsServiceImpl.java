package com.bolton.esd123grocerystore.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bolton.esd123grocerystore.models.Cart;
import com.bolton.esd123grocerystore.models.CartProducts;
import com.bolton.esd123grocerystore.models.Product;
import com.bolton.esd123grocerystore.repositories.CartProductsRepository;
import com.bolton.esd123grocerystore.repositories.CartRepository;
import com.bolton.esd123grocerystore.repositories.ProductRepository;

@Service
public class CartProductsServiceImpl implements CartProductsService{

	@Autowired
	private CartProductsRepository cartProductsRepository;
	@Autowired
	private CartRepository cartRepository;
	@Autowired
	private ProductRepository productRepository;
	@Override
	public CartProducts addProducts(int cartId, int productId) {
		CartProducts cartProducts= new CartProducts();
		Product foundProduct = productRepository.getById(productId);
		cartProducts.setCart(cartId);
		cartProducts.setProduct(foundProduct);
		
		
		return  this.cartProductsRepository.save(cartProducts);
	}

}
