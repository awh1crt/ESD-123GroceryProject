package com.bolton.esd123grocerystore.services;

import org.springframework.stereotype.Service;

import com.bolton.esd123grocerystore.models.User;

@Service
public interface UserService {

	User addUser(User user);
	User findUserById(int id);
	User findUserByEMail(String customerEmail);
	Iterable<User> showAllUsers();
	void deleteById(int id);
	User updateUser(User user);
	User updateUserById(int id);
	Object findAll();
	String validateRegisteredUser(String customerEmail, String password);
	
}
