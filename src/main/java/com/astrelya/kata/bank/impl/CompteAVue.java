package com.astrelya.kata.bank.impl;

import java.math.BigDecimal;

public class CompteAVue {

    private static final double RATE = 0.5;

    private final Double amount;

    public CompteAVue(Double amount) {
        this.amount = amount;
    }

    public Double getAmount() {
        return amount;
    }

    public Double getRate() {
        return RATE;
    }

    public BigDecimal getMonthlyValue() {
        return BigDecimal.valueOf(amount * (RATE / 100) / 12);
    }
}
