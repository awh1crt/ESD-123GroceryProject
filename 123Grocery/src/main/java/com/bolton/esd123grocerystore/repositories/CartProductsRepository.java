package com.bolton.esd123grocerystore.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bolton.esd123grocerystore.models.Cart;
import com.bolton.esd123grocerystore.models.CartProducts;

@Repository

public interface CartProductsRepository extends JpaRepository<CartProducts, Integer> {
	
	public List<CartProducts> findByUserId(int userId);


}
