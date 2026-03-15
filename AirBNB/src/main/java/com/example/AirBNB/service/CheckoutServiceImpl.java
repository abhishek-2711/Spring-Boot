package com.example.AirBNB.service;

import com.example.AirBNB.entity.Booking;
import com.example.AirBNB.entity.User;
import com.example.AirBNB.repository.BookingRepository;
import com.stripe.exception.StripeException;
import com.stripe.model.Customer;
import com.stripe.model.checkout.Session;
import com.stripe.param.CustomerCreateParams;
import com.stripe.param.checkout.SessionCreateParams;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
@Slf4j
public class CheckoutServiceImpl implements CheckoutService{

    private final BookingRepository bookingRepository;

    @Override
    public String getCheckoutSession(Booking booking, String successUrl, String failureUrl) {
        log.info("Creating Session for booking with id: {} " , booking.getId());
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        try {

            CustomerCreateParams customerCreateParams =   CustomerCreateParams.builder()
                    .setEmail(user.getEmail())
                    .setName(user.getName())
                    .build();

            Customer customer = Customer.create(
                    customerCreateParams
            );

            SessionCreateParams sessionParams = SessionCreateParams.builder()
                    .setMode(SessionCreateParams.Mode.PAYMENT)
                    .setBillingAddressCollection(SessionCreateParams.BillingAddressCollection.REQUIRED)
                    .setSuccessUrl(successUrl)
                    .setCustomer(customer.getId())
                    .setCancelUrl(failureUrl)
                    .addLineItem(
                            SessionCreateParams.LineItem.builder()
                                    .setQuantity(1L)
                                    .setPriceData(
                                            SessionCreateParams.LineItem.PriceData.builder()
                                                    .setCurrency("inr")
                                                    .setUnitAmount(booking.getAmount().multiply(BigDecimal.valueOf(100)).longValue())
                                                    .setProductData(
                                                            SessionCreateParams.LineItem.PriceData.ProductData.builder()
                                                                    .setName("Booking for hotel: " + booking.getHotel().getName() + " and room: " + booking.getRoom().getType() + " from date: " + booking.getCheckInDate() + " to date: " + booking.getCheckOutDate())
                                                                    .setDescription("Booking id: " + booking.getId())
                                                                    .build()
                                                    )
                                                    .build())
                                    .build()
                    )
                    .build();

            Session session = Session.create(sessionParams);
            log.info("Session Created Successfully with session id - {} for booking id {} ", session.getId(), booking.getId());
            booking.setPaymentSessionId(session.getId());
            bookingRepository.save(booking);
            return session.getUrl();
        } catch (StripeException e) {
            throw new RuntimeException(e);
        }
    }
}
