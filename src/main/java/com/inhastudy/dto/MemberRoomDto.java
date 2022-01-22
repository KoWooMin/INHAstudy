package com.inhastudy.dto;

import com.inhastudy.domain.Room;
import com.inhastudy.domain.SignUp;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MemberRoomDto {

    private Room room;
    private SignUp member;
}

