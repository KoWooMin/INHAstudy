package com.inhastudy.dto;

import com.inhastudy.domain.Room;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RoomDto {

    private String roomTitle;
    private java.sql.Date reStartDate;
    private java.sql.Date reEndDate;
    private String category;
    //private Integer curJoin;
    private Integer maxJoin;
    private java.sql.Date acStartDate;
    private java.sql.Date acEndDate;
    private String location;
    private String studyCount;
    private Integer studyTime;
    private String activeType;
    private String info;

}