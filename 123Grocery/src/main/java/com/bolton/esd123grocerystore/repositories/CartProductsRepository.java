package com.bolton.esd123grocerystore.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bolton.esd123grocerystore.models.Cart;
import com.bolton.esd123grocerystore.models.CartProducts;

@Repository

public interface CartProductsRepository extends JpaRepository<CartProducts, Integer> {
	
	public List<CartProducts> findByUserId(int userId);

	public CartProducts save(Optional<CartProducts> foundCartProducts);
	
	public boolean existsByCartIdAndUserId(int cartId, int userId);
	
	public Cart getByCartIdAndUserId(int cartId, int userId);
	
//	@Query("select sum (c.subTotalForItem)  from CartProducts c where c.userId like id")
//	double calculateCartTotalForUser(int id);


}
