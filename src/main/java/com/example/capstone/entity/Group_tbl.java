package com.example.capstone.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor  //생성자
@NoArgsConstructor  //default생성자 추가
@Entity  //DB가 해당 객체 인식 가능   (해당 클래스로 테이블을 만듬)
@ToString
@Getter
@Setter

public class Group_tbl {
    @Id  //대표값 like 주민번호
    @GeneratedValue(strategy = GenerationType.IDENTITY) // db가 알아서 생성
    @Column(name = "group_id")
    private Long id;

    @Column (unique = true)
    private String group_code;

    @Column
    private String group_name;

    @Column
    private String matched_schedule;

//    @OneToMany(mappedBy = "group_tbl")
//    private List<User_group> user_groups  ;
}