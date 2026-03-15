package com.example.AirBNB.service;

import com.example.AirBNB.dto.BookingDto;
import com.example.AirBNB.dto.BookingRequest;
import com.example.AirBNB.dto.GuestDto;
import com.stripe.model.Event;

import java.util.List;
import java.util.Map;

public interface BookingService {

    BookingDto initialiseBooking(BookingRequest bookingRequest);

    BookingDto addGuests(Long bookingId, List<GuestDto> guestDtoList);

    String initiatePayment(Long bookingId);

    void capturePayment(Event event);
}
