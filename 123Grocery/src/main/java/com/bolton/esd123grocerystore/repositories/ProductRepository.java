package com.bolton.esd123grocerystore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bolton.esd123grocerystore.models.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{
	@Query("select p from Product p where lower(p.productName) like lower(concat('%',:name, '%')) or lower(p.productName) like lower(concat('%',:name, '%'))")
	Iterable<Product> findByNameIgnoreCase(String name);

	
	

}
