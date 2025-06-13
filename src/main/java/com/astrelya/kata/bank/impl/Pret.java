package com.astrelya.kata.bank.impl;

import java.math.BigDecimal;

public class Pret {

    private static final double RATE = 2.0;

    private final Double amount;

    public Pret(Double amount) {
        this.amount = amount;
    }

    public Double getAmount() {
        return amount;
    }

    public Double getRate() {
        return RATE;
    }

    public BigDecimal getMonthlyValue() {
        return BigDecimal.valueOf(-amount * (RATE / 100) / 12);
    }
}
