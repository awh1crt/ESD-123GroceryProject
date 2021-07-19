package com.bolton.esd123grocerystore;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.bolton.esd123grocerystore.models.User;
import com.bolton.esd123grocerystore.repositories.UserRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
@Rollback(false)
public class UserTest {
	@Autowired
	UserRepository userRepository;
	@Autowired
	private EntityManager entityManager;
	
	@Test
	public void addNewUser() {
		
		User newUser = new User();
		newUser.setUserFirstName("Bill");
		newUser.setUserLastName("Smith");
		newUser.setUserAddress("bill home");
		newUser.setUserEmail("bill@home.com");
		newUser.setUserPassword("password");
		System.out.println(newUser);
		
		User savedUser = userRepository.save(newUser);
		
		System.out.println(savedUser);
		
		User existUser =  entityManager.find(User.class, savedUser.getUserId());
		
		assertThat(existUser.getUserEmail().equals(newUser.getUserEmail()));
	}
	@Test
	public void addSecondNewUser() {
		
		User newUser = new User();
		newUser.setUserFirstName("Ted");
		newUser.setUserLastName("Jones");
		newUser.setUserAddress("Ted home");
		newUser.setUserEmail("ted@home.com");
		newUser.setUserPassword("password");
		System.out.println(newUser);
		
		User savedUser = userRepository.save(newUser);
		
		System.out.println(savedUser);
		
		User existUser =  entityManager.find(User.class, savedUser.getUserId());
		
		assertThat(existUser.getUserEmail().equals(newUser.getUserEmail()));
	}
	
	@Test
	public void deleteUserById() {
		int userId = 2;
		User savedUser = userRepository.getById(userId);
		System.out.println(savedUser);
		assertThat(savedUser.getUserId() == 2);
		userRepository.deleteById(userId);
		Long rowCount = userRepository.count();
		assertEquals(1,rowCount);
	}

}
