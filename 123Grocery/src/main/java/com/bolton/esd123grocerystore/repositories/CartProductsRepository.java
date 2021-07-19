package com.bolton.esd123grocerystore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bolton.esd123grocerystore.models.CartProducts;

@Repository

public interface CartProductsRepository extends JpaRepository<CartProducts, Integer> {

}
