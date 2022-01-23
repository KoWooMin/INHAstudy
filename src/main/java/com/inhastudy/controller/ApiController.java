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
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

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

    @PutMapping("/api/addCurJoin/{roomId}")
    public String addCurJoin(@PathVariable Long roomId){
        Room room = roomRepository.findById(roomId).orElse(null);
        Integer curJoin = room.getCurJoin();
        Integer maxJoin = room.getMaxJoin();
        if(curJoin<maxJoin){
            roomService.addCurJoin(room);
            return "approve";
        }
        return "reject";
    }

    @GetMapping("/api/insertRoomId/{roomId}/{memberId}")
    public void insertRoomId(@PathVariable Long roomId, @PathVariable String memberId){
        Room room = roomRepository.findById(roomId).orElse(null);
        SignUp member = signUpRepository.findById(memberId).orElse(null);
        MemberRoomDto memberRoomDto = new MemberRoomDto(room, member);
        MemberRoom memberRoom = new MemberRoom(memberRoomDto);
        memberRoomRepository.save(memberRoom);

    }

    @GetMapping("/api/CheckDuplicate/{roomId}/{memberId}")
    public String CheckDuplicate(@PathVariable Long roomId, @PathVariable String memberId){
        Room room = roomRepository.findById(roomId).orElse(null);
        List<String> findMemberList = memberRoomRepository.findMemberListByRoomId(roomId);
        for(int i = 0; i< room.getMaxJoin(); i++) {
            if (memberId.equals(findMemberList.get(i))) {
                return "AlreadyRegistered";
            }
        }
        return "join";

        //memberRoom.getMember()
    }
}

