package com.bolton.esd123grocerystore.models;

import java.util.Optional;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity

public class CartProducts {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;
	
	@ManyToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name = "product_id")
	private Product product;
	
	private int cartId;

	
	public CartProducts(Product product, int cartId) {
		super();
		this.product = product;
		this.cartId = cartId;
	}

	public CartProducts() {
		// TODO Auto-generated constructor stub
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getCartId() {
		return cartId;
	}

	public void setCart(int foundCart) {
		this.cartId = foundCart;
	}

	@Override
	public String toString() {
		return "CartProducts [Id=" + Id + ", product=" + product + ", cart=" + cartId + "]";
	}
	
	

}
