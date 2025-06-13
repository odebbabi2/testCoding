package com.astrelya.kata.bank.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;

import com.astrelya.kata.bank.IClient;

public class Client implements IClient {
	private final String email;
	private final Collection<Object> productList = new ArrayList<>();
	private BigDecimal monthyBalance = java.math.BigDecimal.ZERO;

	public Client(String email) {
		if(!email.matches("^[\\w.-]@[\\w.-]+\\.[a-zA-Z]{2,}$")) {
			throw new IllegalArgumentException(email+"is not valid email");
		}
		this.email = email;
	}

	@Override
	public String getEmail() {
		return email;
	}

	@Override
	public Collection<Object> getProductList() {
		return productList;
	}

	@Override
	public BigDecimal getMonthlyBalance() {
		return monthyBalance;
	}

	@Override
	public void addProduct(String productType, Double amount) {
		productList.add(productType + "-" + amount);
		monthyBalance=monthyBalance.add(BigDecimal.valueOf(amount));
		
	}
	
}
