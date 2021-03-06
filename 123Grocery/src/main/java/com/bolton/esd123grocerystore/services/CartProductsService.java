package com.bolton.esd123grocerystore.services;

import org.springframework.stereotype.Service;

import com.bolton.esd123grocerystore.models.CartProducts;

@Service
public interface CartProductsService {
	
	CartProducts addProducts(int cartId, int productId,int quantity, int userId);
	CartProducts updateQuantityByOne(int cartId);
	
	void updateCartProductsSubTotal(int cartId);
	

	
	
	
	

}
