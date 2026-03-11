package com.example.AirBNB.repository;

import com.example.AirBNB.entity.Inventory;
import com.example.AirBNB.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {

    void deleteByDateAfterAndRoom(LocalDate date, Room room);
}
