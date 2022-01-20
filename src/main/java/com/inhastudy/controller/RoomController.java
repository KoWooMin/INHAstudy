package com.inhastudy.controller;

import com.inhastudy.domain.Room;
import com.inhastudy.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@RequiredArgsConstructor
@Controller
public class RoomController {

    private final RoomRepository roomRepository;

    @GetMapping("/")
    public String home(Model model) {
        List<Room> roomList = roomRepository.findAll();
        Collections.reverse(roomList);
        model.addAttribute("roomList", roomList);
        return "home";
    }

    @GetMapping("login")
    public String login() {

        return "login";
    }

    @GetMapping("mypage")
    public String moveMyPage(){
        return "mypage";
    }

    @GetMapping("/home/{id}")
    public String showRoom(@PathVariable Long id, Model model) {
        Room room = roomRepository.findById(id).orElse(null);
        model.addAttribute("room", room);
        return "home";
    }

    @GetMapping("/home/search")
    public String search(@RequestParam(value ="roomTitle") String roomTitle, Model model) {
        List<Room> roomList = roomRepository.findByRoomTitleContainingIgnoreCase(roomTitle);
        model.addAttribute("roomList", roomList);
        return "home";
    }





}