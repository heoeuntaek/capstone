package com.example.capstone.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@AllArgsConstructor  //생성자
@NoArgsConstructor  //default생성자 추가
@Entity  //DB가 해당 객체 인식 가능   (해당 클래스로 테이블을 만듬)
@ToString
@Getter
@Table (name = "user_group")
public class User_group {

    @Id  //대표값 like 주민번호
    @GeneratedValue(strategy = GenerationType.IDENTITY) // db가 알아서 생성
    private Long id;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    @ManyToOne
    @JoinColumn(name = "groupId")
    private Group_tbl group_tbl;


    @Column
    private String shared_schedule;




}