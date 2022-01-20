package com.inhastudy.repository;

import com.inhastudy.domain.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RoomRepository extends JpaRepository<Room, Long> {

    List<Room> findByRoomTitleContainingIgnoreCase(String roomTitle);
    Room findRoomById(Long id);
}
