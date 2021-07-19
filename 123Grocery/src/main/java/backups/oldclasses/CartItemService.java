package backups.oldclasses;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bolton.esd123grocerystore.models.Cart;
import com.bolton.esd123grocerystore.models.User;

@Service
public interface CartItemService {
	
	CartItem addCartItem(CartItem cartItem);
	
	Object showAllCartItems();
	
	CartItem addCartItems(int productId, int quantity);
	
	List<CartItem> showAllCartItemsByUser(User user);

	CartItem addCartItems(int productId, int quantity, String user);

	CartItem addCartItems(Cart cart);

	Cart addCartItem(Cart cart);

	

}
