package backups.oldclasses;

import java.util.HashMap;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.bolton.esd123grocerystore.models.User;
import com.bolton.esd123grocerystore.services.UserService;


@Controller
@SessionAttributes("userName")

public class CartItemController {
	
	@Autowired
	private CartItemService cartItemService;
	@Autowired
	private CartItemRepository cartItemRepository;
	
	@Autowired
	private UserService userService;		
	

	@RequestMapping(value = "/cart", method = { RequestMethod.GET})
	public String showCart(Model model, @ModelAttribute("userName") String user){
		User foundUser = userService.findUserByEMail(user);
		List<CartItem> cartItems = cartItemRepository.findByUser(foundUser);
		((HashMap<String, Object>) model).put("cart", cartItems);
		System.out.println("Cart items = " + cartItems);
		
		return("/cart");
		
		
		
	}
	@GetMapping("/checkout")
	public String showCheckOut() {
		return "/checkout";
	}
	
	@GetMapping("/buyProduct")
	public String buyProduct(int productId, int quantity, String user) {
		System.out.println("product ID = " + productId);
		System.out.println("QTY = " + quantity);
		System.out.println("USRE = " + user);
		cartItemService.addCartItems(productId, quantity, user);
		return "/cart";
	}
	
	
//	@PostMapping("/buyProduct")
//	public String buyProduct(int productId, int quantity, String user) {
//		System.out.println("product ID = " + productId);
//		System.out.println("QTY = " + quantity);
//		System.out.println("USRE = " + user);
//		cartItemService.addCartItems(productId, quantity, user);
//		return ("/productDetails");
//	}
	 
	}
