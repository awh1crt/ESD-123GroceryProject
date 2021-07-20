package com.bolton.esd123grocerystore.services;

import org.springframework.stereotype.Service;

import com.bolton.esd123grocerystore.models.UserCheckOut;

@Service
public interface UserCheckOutService {
	
	UserCheckOut addCheckOut(UserCheckOut checkOut);
	Object findAll();
	UserCheckOut newCheckOutByUserIdAndCartId(int userIdentity);
	void updateCheckOutTotalPrice(int orderId);
	

}
