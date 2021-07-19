package com.bolton.esd123grocerystore.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bolton.esd123grocerystore.models.Cart;
import com.bolton.esd123grocerystore.models.User;
import com.bolton.esd123grocerystore.repositories.CartRepository;
import com.bolton.esd123grocerystore.repositories.ProductRepository;
import com.bolton.esd123grocerystore.repositories.UserRepository;


@Service
public class CartServiceImpl implements CartService {
	
	@Autowired
	ProductRepository productRespository;
	
	@Autowired
	ProductService productService;
	
	@Autowired
	UserRepository  userRespository; 
	
	@Autowired
	UserService userService;
	
	@Autowired
	CartRepository cartRepository;



	



	@Override
	public Cart addItemToCartByProductAndQuantity(int productid, int quantity) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public List<Cart> showAllItemsInUserCart(User user) {
		int userId = user.getUserId();
		
		return null;
	}



	@Override
	public Cart addItemstoCartByProductAndQuantityAndUser(int productid, int quantity, int userId) {
		Cart newCartItem = new Cart();
		newCartItem.setProductId(productid);
		newCartItem.setQuantity(quantity);
		newCartItem.setUserId(userId);
		return cartRepository.save(newCartItem);
		
	}



	@Override
	public Cart addCartItem(Cart cart) {
		return this.cartRepository.save(cart);
	}



	@Override
	public Object showAllCartItems() {
		// TODO Auto-generated method stub
		return null;
	}

}
