package backups.oldclasses;

import java.util.List;

import java.util.Optional;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bolton.esd123grocerystore.models.Cart;
import com.bolton.esd123grocerystore.models.Product;
import com.bolton.esd123grocerystore.models.User;
import com.bolton.esd123grocerystore.repositories.ProductRepository;
import com.bolton.esd123grocerystore.repositories.UserRepository;
import com.bolton.esd123grocerystore.services.ProductService;
import com.bolton.esd123grocerystore.services.UserService;

@Service
public class CartItemServiceImpl implements CartItemService {
	
	@Autowired
	ProductRepository productRespository;
	
	@Autowired
	ProductService productService;
	
	@Autowired
	UserRepository  userRespository; 
	
	@Autowired
	UserService userService;
	
	private CartItemRepository cartItemRepository;
	
	

	@Override
	public CartItem addCartItem(CartItem cartItem) {
		return this.cartItemRepository.save(cartItem);
	}

	@Override
	public Object showAllCartItems() {
		System.out.println("in show all cart items");
		
		//List<CartItem> cartItems = cartItemRepository.findAll();
		Optional<CartItem> items = cartItemRepository.findById(1);
		System.out.println("cart items + " + items);
		return null;
	}

	
	@Override
	public CartItem addCartItems(int productId, int quantity, String user) {
				
		Product findProduct = productService.findProductById(productId); 
		User foundUser=userService.findUserByEMail(user);
		CartItem cartItem = new CartItem();
		int cartItemId = cartItem.getCartItemId();
		System.out.println("cart item id = " + cartItemId);
		cartItem.setUser(foundUser);
		cartItem.setProduct(findProduct);
		cartItem.setQuantity(quantity);
		System.out.println(cartItem);
		return cartItemRepository.save(cartItem);
	}

	@Override
	public List<CartItem> showAllCartItemsByUser(User user) {
		return cartItemRepository.findByUser(user);
	}

	@Override
	public CartItem addCartItems(int productId, int quantity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CartItem addCartItems(Cart cart) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cart addCartItem(Cart cart) {
		// TODO Auto-generated method stub
		return null;
	}





	

}
