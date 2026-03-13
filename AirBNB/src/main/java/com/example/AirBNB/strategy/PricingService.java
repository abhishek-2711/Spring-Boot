package com.example.AirBNB.strategy;

import com.example.AirBNB.entity.Inventory;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class PricingService {

    public BigDecimal calculateDynamicPricing(Inventory inventory) {
        PricingStrategy pricingStrategy = new BasePricingStrategy();
        pricingStrategy = new SurgePricingStrategy(pricingStrategy);
        pricingStrategy = new HolidayPricingStrategy(pricingStrategy);
        pricingStrategy = new UrgencyPricingStrategy(pricingStrategy);
        pricingStrategy = new OccupancePricingStrategy(pricingStrategy);
        return pricingStrategy.calculatePrice(inventory);
    }

}