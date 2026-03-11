package com.example.AirBNB.service;


import com.example.AirBNB.entity.Room;

public interface InventoryService {

    void initializeRoomForAYear(Room room);

    void deleteFutureInventories(Room room);

}
