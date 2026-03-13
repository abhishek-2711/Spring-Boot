package com.example.AirBNB.service;


import com.example.AirBNB.dto.HotelDto;
import com.example.AirBNB.dto.HotelPriceDto;
import com.example.AirBNB.dto.HotelSearchRequestDto;
import com.example.AirBNB.entity.Room;
import org.springframework.data.domain.Page;

public interface InventoryService {

    void initializeRoomForAYear(Room room);

    void deleteAllInventories(Room room);

    Page<HotelPriceDto> searchHotels(HotelSearchRequestDto hotelSearchRequestDto);
}
