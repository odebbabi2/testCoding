package com.astrelya.kata.bank.impl;

import java.math.BigDecimal;

import org.apache.commons.lang3.NotImplementedException;


public class LDD {

	private Double rate;
	private Double amount;
	
	public LDD(Double amount) {
		this.amount = amount;
	}
	
	public Double getAmount() {
		return amount;
	}
	
	public Double getRate() {
		return rate;
	}
	
	public BigDecimal getMonthlyValue() {
		throw new NotImplementedException();
	}
}
