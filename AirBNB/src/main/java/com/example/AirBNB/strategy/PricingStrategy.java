package com.example.AirBNB.strategy;

import com.example.AirBNB.entity.Inventory;

import java.math.BigDecimal;

public interface PricingStrategy {

    BigDecimal calculatePrice(Inventory inventory);

}
