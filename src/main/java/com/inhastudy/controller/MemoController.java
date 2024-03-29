package com.inhastudy.controller;

import com.inhastudy.domain.*;
import com.inhastudy.repository.MemberRoomRepository;
import com.inhastudy.repository.MemoRepository;
import com.inhastudy.repository.RoomRepository;
import com.inhastudy.service.MemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class MemoController {

    private final RoomRepository roomRepository;
    private final MemoRepository memoRepository;
    private final MemoService memoService;
    private final MemberRoomRepository memberRoomRepository;

    @PostMapping("/api/memos")
    public Memo createMemo(@RequestBody MemoRequestDto requestDto){
        Memo memo = new Memo(requestDto);
        return memoRepository.save(memo);
    }

    @GetMapping("/api/memos")
    public List<Memo> readMemo(){
        LocalDateTime start = LocalDateTime.now().minusYears(1);
        LocalDateTime end = LocalDateTime.now();
        return memoRepository.findAllByModifiedAtBetweenOrderByModifiedAtDesc(start, end);
    }


    @GetMapping("/api/memos/{roomId}")
    public List<Memo> readRoomMemo(@PathVariable String roomId ){
        return memoRepository.findAllByRoomNumOrderByModifiedAtDesc(roomId);
    }

    @DeleteMapping("/api/memos/{id}")
    public Long deleteMemo(@PathVariable Long id){
        memoRepository.deleteById(id);
        return id;
    }

    @PutMapping("/api/memos/{id}")
    public Long updateMemo(@PathVariable Long id, @RequestBody MemoRequestDto requestDto){
        memoService.update(id, requestDto);
        return id;
    }

    @GetMapping("/rooms/{id}")
    public Room getOneRoom(@PathVariable String id){
        return roomRepository.findRoomById(Long.parseLong(id));
    }

    @GetMapping("/join/{roomId}")
    public List<SignUp> getJoinUsers(@PathVariable String roomId){
        Long temp = Long.parseLong(roomId);
        return memberRoomRepository.findMemberByRoomId(temp);
    }

}
