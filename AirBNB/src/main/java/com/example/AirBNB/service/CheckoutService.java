package com.example.AirBNB.service;

import com.example.AirBNB.entity.Booking;

public interface CheckoutService {

    String getCheckoutSession(Booking booking, String successUrl, String failureUrl);

}
