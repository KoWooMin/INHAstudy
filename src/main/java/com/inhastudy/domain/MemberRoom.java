package com.inhastudy.domain;

import com.inhastudy.dto.MemberRoomDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter

public class MemberRoom {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(targetEntity = SignUp.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "memberId")
    private SignUp member;

    @ManyToOne(targetEntity = Room.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "roomId")
    private Room room;

    public MemberRoom(MemberRoomDto memberRoomDto) {
        this.member = memberRoomDto.getMember();
        this.room = memberRoomDto.getRoom();
    }
}
