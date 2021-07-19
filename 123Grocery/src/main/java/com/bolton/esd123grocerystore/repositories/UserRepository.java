package com.bolton.esd123grocerystore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bolton.esd123grocerystore.models.User;




@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

	User findByUserEmail(String username);

}
