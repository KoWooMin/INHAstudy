package com.inhastudy.repository;

import com.inhastudy.domain.Memo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface MemoRepository extends JpaRepository<Memo, Long> {

    List<Memo> findAllByModifiedAtBetweenOrderByModifiedAtDesc(LocalDateTime start, LocalDateTime end);
    List<Memo> findAllByRoomNumOrderByModifiedAtDesc(String RoomNum);
}
