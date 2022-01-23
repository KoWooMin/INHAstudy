package com.inhastudy.service;

import com.inhastudy.domain.Room;
import com.inhastudy.domain.SignUp;
import com.inhastudy.dto.RoomDto;
import com.inhastudy.dto.RoomForm;
import com.inhastudy.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class RoomService {

    private RoomRepository roomRepository;

    @Transactional
    public Long update(Long id, RoomDto roomDto) {
        Room room = roomRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("정보 수정에 실패하였습니다.")
        );
        room.update(roomDto);
        return room.getId();
    }

    @Transactional
    public void addCurJoin(Room room) {
        room.addCurJoin();
    }
}