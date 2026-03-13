package com.example.AirBNB.controller;

import com.example.AirBNB.dto.HotelDto;
import com.example.AirBNB.dto.HotelInfoDto;
import com.example.AirBNB.dto.HotelPriceDto;
import com.example.AirBNB.dto.HotelSearchRequestDto;
import com.example.AirBNB.service.HotelService;
import com.example.AirBNB.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/hotels")
public class HotelBrowseController {

    private final InventoryService inventoryService;
    private final HotelService hotelService;

    @GetMapping("/search")
    public ResponseEntity<Page<HotelPriceDto>> searchHotels(@RequestBody HotelSearchRequestDto hotelSearchRequestDto) {
        Page<HotelPriceDto> page = inventoryService.searchHotels(hotelSearchRequestDto);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{hotelId}/info")
    public ResponseEntity<HotelInfoDto > getHotelById(@PathVariable Long hotelId) {
        HotelInfoDto hotelInfoDto = hotelService.getHotelInfoById(hotelId);
        return ResponseEntity.ok(hotelInfoDto);
    }

}
