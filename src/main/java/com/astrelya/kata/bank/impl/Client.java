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
		if (!email.matches("^[\\w.-]@[\\w.-]+\\.[a-zA-Z]{2,}$")) {
			throw new IllegalArgumentException(email + "is not valid email");
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
        String productKey = productType.toLowerCase();

        for (Object obj : productList) {
            if (obj.getClass().getSimpleName().equalsIgnoreCase(productType)) {
                throw new IllegalArgumentException(email + " cannot have two " + productType);
            }
        }
        Object product = switch (productKey) {
        case "livreta" -> new LivretA(amount);
        case "ldd" -> new LDD(amount);
        case "compteavue" -> new CompteAVue(amount);
        default -> throw new IllegalArgumentException("Unknown product type: " + productType);
    };

    productList.add(product);

    BigDecimal monthlyValue = switch (productKey) {
        case "livreta" -> ((LivretA) product).getMonthlyValue();
        case "ldd" -> ((LDD) product).getMonthlyValue();
        case "compteavue" -> ((CompteAVue) product).getMonthlyValue();
        default -> BigDecimal.ZERO;
    };

    monthlyBalance = monthlyBalance.add(monthlyValue);
}
}
