package com.bolton.esd123grocerystore.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bolton.esd123grocerystore.models.Cart;
import com.bolton.esd123grocerystore.models.User;

@Service
public interface CartService {
	
	Cart addCartItem(Cart cart);
	Object showAllCartItems();
	Cart addItemToCartByProductAndQuantity(int productid, int quantity);
	List<Cart> showAllItemsInUserCart(User user);
	Cart addItemstoCartByProductAndQuantityAndUser(int productid, int quantity, int userId);

}
