package com.inhastudy.controller;

import com.inhastudy.domain.Room;
import com.inhastudy.dto.RoomForm;
import com.inhastudy.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Controller
public class RoomController {

    private final RoomRepository roomRepository;

    @GetMapping("/home")
    public String home(Model model) {

        List<Room> roomList = roomRepository.findAll();
        model.addAttribute("roomList", roomList);
        return "home";
    }

    @GetMapping("/home/{id}")
    public String show(@PathVariable Long id, Model model) {

        Room room = roomRepository.findById(id).orElse(null);
        model.addAttribute("room", room);
        return "home";
    }

    @GetMapping("/home/search")
    public String show(@RequestParam(value ="roomTitle") String roomTitle, Model model) {

        List<Room> roomList = roomRepository.findByRoomTitleContainingIgnoreCase(roomTitle);
        model.addAttribute("roomList", roomList);
        return "home";
    }


}
