package com.bolton.esd123grocerystore.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bolton.esd123grocerystore.models.User;
import com.bolton.esd123grocerystore.repositories.UserRepository;


@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;
	
	@Override
	public User addUser(User user) {
		return this.userRepository.save(user);
	}

	@Override
	public User findUserById(int id) {
		return this.userRepository.getById(id);
	}

	@Override
	public User findUserByEMail(String customerEmail) {
		return this.userRepository.findByUserEmail(customerEmail);
	}

	@Override
	public Iterable<User> showAllUsers() {
		return null;
	}

	@Override
	public void deleteById(int id) {

	}

	@Override
	public User updateUser(User user) {
		return null;
	}

	@Override
	public User updateUserById(int id) {
		return null;
	}

	@Override
	public Object findAll() {
		return null;
	}

	@Override
	public String validateRegisteredUser(String customerEmail, String password) {
		String name = null;
		for (User user : userRepository.findAll()) {
			if(user.getUserEmail().equals(customerEmail) && user.getUserPassword().equals(password) ) {
				name = user.getUserEmail();
				
			}
		}
		
		return name;
	}

	

}
