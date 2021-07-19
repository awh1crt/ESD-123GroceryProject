package com.bolton.esd123grocerystore.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bolton.esd123grocerystore.models.Cart;
import com.bolton.esd123grocerystore.models.User;


@Repository
public interface CartRepository extends JpaRepository<Cart, Integer>{
	
	public List<Cart> findByUserId(int userId);

}
