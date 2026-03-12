package com.example.AirBNB.service;

import com.example.AirBNB.dto.BookingDto;
import com.example.AirBNB.dto.BookingRequest;
import com.example.AirBNB.dto.GuestDto;

import java.util.List;

public interface BookingService {

    BookingDto initialiseBooking(BookingRequest bookingRequest);

    BookingDto addGuests(Long bookingId, List<GuestDto> guestDtoList);
}
