package com.example.AirBNB.strategy;

import com.example.AirBNB.entity.Inventory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;


@RequiredArgsConstructor
public class HolidayPricingStrategy implements PricingStrategy{

    private final PricingStrategy wrapped;


    @Override
    public BigDecimal calculatePrice(Inventory inventory) {
        BigDecimal price = wrapped.calculatePrice(inventory);
        if(inventory.getDate().getMonthValue() == 12) {
            price = price.multiply(BigDecimal.valueOf(1.25));
        }
        return price;
    }
}
