package com.inhastudy.controller;

import com.inhastudy.domain.MemberRoom;
import com.inhastudy.domain.Room;
import com.inhastudy.repository.MemberRoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collections;
import java.util.List;

@RequiredArgsConstructor
@Controller
public class MemberRoomController {

    private final MemberRoomRepository memberRoomRepository;


    @GetMapping("/mypage/{memberId}")
    public String myPage(@PathVariable String memberId, Model model) {
        List<Room> roomList = memberRoomRepository.findRoomByMemberId(memberId);
        Collections.reverse(roomList);
        model.addAttribute("roomList", roomList);
        return "mypage";
    }

}
