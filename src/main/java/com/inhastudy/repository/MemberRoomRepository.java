package com.inhastudy.repository;

import com.inhastudy.domain.MemberRoom;
import com.inhastudy.domain.Room;
import com.inhastudy.domain.SignUp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MemberRoomRepository extends JpaRepository<MemberRoom, Long> {

    @Query(value = "select T.room from MemberRoom as T where T.member.id = :memberId")
    List<Room> findRoomByMemberId(@Param("memberId") String memberId);

    @Query(value = "select T.member from MemberRoom as T where T.room.id = :roomId")
    List<SignUp> findMemberByRoomId(@Param("roomId") Long roomId);

    @Query(value = "select T.room.id from MemberRoom as T where T.member.id = :memberId")
    Long findRoomIdByMemberId(@Param("memberId") String memberId);

    @Query(value = "select T.member from MemberRoom as T where T.member.id = :memberId")
    SignUp findMemberByMemberId(@Param("memberId") String memberId);

    @Query(value = "select T.member.id from MemberRoom as T where T.room.id = :roomId")
    List<String> findMemberListByRoomId(@Param("roomId") Long roomId);

}
