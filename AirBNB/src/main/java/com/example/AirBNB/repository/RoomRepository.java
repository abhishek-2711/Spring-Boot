package com.example.AirBNB.repository;

import com.example.AirBNB.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Long> {
}
