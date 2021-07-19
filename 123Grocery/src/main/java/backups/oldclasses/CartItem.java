package backups.oldclasses;

import java.util.Optional;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.bolton.esd123grocerystore.models.Product;
import com.bolton.esd123grocerystore.models.User;


@Entity
public class CartItem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cartItemId;
	
	@ManyToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name="user_id")
	private User user;
	
	
	
	@ManyToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name = "product_id")
	private Product product;
	
	private int quantity;
	
	public CartItem (int quantity, User user, Product product) {
		super();
		this.quantity=quantity;
		this.user=user;
		this.product=product;
	}
	public CartItem() {
		super();
	}

	
	
	public User getuser() {
		return user;
	}

	public void setUser(User foundUser) {
		this.user = foundUser;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product findProduct) {
		this.product = findProduct;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getCartItemId() {
		return cartItemId;
	}

	public void setCartItemId(int cartItemId) {
		this.cartItemId = cartItemId;
	}
	@Override
	public String toString() {
		return "CartItem [cartItemId=" + cartItemId + ", user=" + user + ", product=" + product + ", quantity="
				+ quantity + "]";
	}

	
}

