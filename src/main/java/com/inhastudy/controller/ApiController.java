package com.inhastudy.controller;

import com.inhastudy.domain.Room;
import com.inhastudy.dto.RoomDto;
import com.inhastudy.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class ApiController {

    private final RoomRepository roomRepository;

    @PostMapping("/api")
    public Room createRoom(@RequestBody RoomDto dto) {
        Room room = new Room(dto);
        return roomRepository.save(room);
    }

}
