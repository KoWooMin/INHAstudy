package com.inhastudy.controller;

import com.inhastudy.domain.MemberRoom;
import com.inhastudy.domain.Room;
import com.inhastudy.domain.SignUp;
import com.inhastudy.dto.MemberRoomDto;
import com.inhastudy.dto.RoomDto;
import com.inhastudy.repository.MemberRoomRepository;
import com.inhastudy.repository.RoomRepository;
import com.inhastudy.repository.SignUpRepository;
import com.inhastudy.service.RoomService;
import com.inhastudy.service.SignUpService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class ApiController {

    private final MemberRoomRepository memberRoomRepository;
    private final RoomRepository roomRepository;
    private final RoomService roomService;
    private final SignUpRepository signUpRepository;

    @PostMapping("/api")
    public Room createRoom(@RequestBody RoomDto dto) {
        Room room = new Room(dto);
        return roomRepository.save(room);
    }

    @PutMapping("/api/addCurJoin/{roomId}") // 로그인한 사용자 checkLogin을 Y로 변경
    public void addCurJoin(@PathVariable Long roomId){

        Room room = roomRepository.findById(roomId).orElse(null);
        roomService.addCurJoin(room);
    }

    @GetMapping("/api/insertRoomId/{roomId}/{memberId}")
    public void insertRoomId(@PathVariable Long roomId, @PathVariable String memberId){
        Room room = roomRepository.findById(roomId).orElse(null);
        SignUp member = signUpRepository.findById(memberId).orElse(null);
        MemberRoomDto memberRoomDto = new MemberRoomDto(room, member);
        MemberRoom memberRoom = new MemberRoom(memberRoomDto);
        memberRoomRepository.save(memberRoom);
    }
}
