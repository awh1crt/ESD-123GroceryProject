package com.bolton.esd123grocerystore.models;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class UserCheckOut {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderId;
	
	
	private int userIdentity;
	
	private double orderTotal;
	private Date dateOrderCreated;
	private boolean paymentReceived;
	
	@ManyToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name = "user_id")
	private User userId;
	
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getUserId() {
		return userIdentity;
	}
	public void setUserId(int userIdentity) {
		this.userIdentity = userIdentity;
	}
	public double getOrderTotal() {
		return orderTotal;
	}
	public void setOrderTotal(double orderTotal) {
		this.orderTotal = orderTotal;
	}
	public Date getDateOrderCreated() {
		return dateOrderCreated;
	}
	public void setDateOrderCreated(Date dateOrderCreated) {
		this.dateOrderCreated = dateOrderCreated;
	}
	public boolean isPaymentReceived() {
		return paymentReceived;
	}
	public void setPaymentReceived(boolean paymentReceived) {
		this.paymentReceived = paymentReceived;
		
		
	}

	
	
	public User getUser() {
		return userId;
	}
	public void setUser(User user) {
		this.userId = user;
	}
	@Override
	public String toString() {
		return "UserCheckOut [orderId=" + orderId + ", userIdentity=" + userIdentity + ", orderTotal=" + orderTotal
				+ ", dateOrderCreated=" + dateOrderCreated + ", paymentReceived=" + paymentReceived + ", user=" + userId
				+ "]";
	}
	
	

}
