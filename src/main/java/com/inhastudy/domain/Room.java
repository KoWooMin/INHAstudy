package com.inhastudy.domain;

import com.inhastudy.dto.RoomDto;
import com.inhastudy.dto.SignUpRequestDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@DynamicInsert
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String roomTitle;

    @Column(nullable = false)
    private java.sql.Date reStartDate;

    @Column(nullable = false)
    private java.sql.Date reEndDate;

    @Column(nullable = false)
    private String category;

    @ColumnDefault("1")
    private Integer curJoin;

    @Column(nullable = false)
    private Integer maxJoin;

    @Column(nullable = false)
    private java.sql.Date acStartDate;

    @Column(nullable = false)
    private java.sql.Date acEndDate;

    @Column(nullable = false)
    private String location;

    @Column(nullable = false)
    private String studyCount;

    @Column(nullable = false)
    private Integer studyTime;

    @Column(nullable = false)
    private String activeType;

    @Column(nullable = true)
    private String info;

    @Column(nullable = false)
    private String hostId;

    @ColumnDefault("'N'")
    private String joinEnd;

    public Room(RoomDto requestDto) {
        this.roomTitle = requestDto.getRoomTitle();
        this.reStartDate=requestDto.getReStartDate();
        this.reEndDate = requestDto.getReEndDate();
        this.category = requestDto.getCategory();
        this.curJoin = requestDto.getCurJoin();
        this.maxJoin = requestDto.getMaxJoin();
        this.acStartDate = requestDto.getAcStartDate();
        this.acEndDate = requestDto.getAcEndDate();
        this.location = requestDto.getLocation();
        this.studyCount= requestDto.getStudyCount();
        this.studyTime = requestDto.getStudyTime();
        this.activeType = requestDto.getActiveType();
        this.info = requestDto.getInfo();
        this.hostId=requestDto.getHostId();
        this.joinEnd=requestDto.getJoinEnd();
    }

    public void update(RoomDto requestDto){
        this.roomTitle = requestDto.getRoomTitle();
        this.reStartDate=requestDto.getReStartDate();
        this.reEndDate = requestDto.getReEndDate();
        this.category = requestDto.getCategory();
        this.curJoin = requestDto.getCurJoin();
        this.maxJoin = requestDto.getMaxJoin();
        this.acStartDate = requestDto.getAcStartDate();
        this.acEndDate = requestDto.getAcEndDate();
        this.location = requestDto.getLocation();
        this.studyCount= requestDto.getStudyCount();
        this.studyTime = requestDto.getStudyTime();
        this.activeType = requestDto.getActiveType();
        this.info = requestDto.getInfo();
        this.hostId=requestDto.getHostId();
        this.joinEnd=requestDto.getJoinEnd();
    }

    public void addCurJoin(){
        this.curJoin += 1;
    }

    public void updateJoinEnd(String joinEnd){
        this.joinEnd = joinEnd;
    }

}


