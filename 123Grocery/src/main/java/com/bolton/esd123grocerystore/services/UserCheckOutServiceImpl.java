package com.bolton.esd123grocerystore.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bolton.esd123grocerystore.models.UserCheckOut;
import com.bolton.esd123grocerystore.repositories.UserCheckOutRepository;

@Service
public class UserCheckOutServiceImpl implements UserCheckOutService {

	@Autowired
	private UserCheckOutRepository userCheckOutRepository;
	@Override
	public UserCheckOut addCheckOut(UserCheckOut checkOut) {
		return this.userCheckOutRepository.save(checkOut);
	}

	@Override
	public Object findAll() {
		return null;
	}

	@Override
	public UserCheckOut newCheckOutByUserIdAndCartId(int userIdentity) {
		UserCheckOut userCheckOut = new UserCheckOut();
		userCheckOut.setUserId(userIdentity);	
		Date date = new Date();
		userCheckOut.setDateOrderCreated(date);
		userCheckOut.setOrderTotal(0);
		userCheckOut.setPaymentReceived(false);
		userCheckOut.setUserId(userIdentity);
		userCheckOutRepository.save(userCheckOut);
		return userCheckOut;
	}

	@Override
	public void updateCheckOutTotalPrice(int orderId) {
		
		
	}
}
