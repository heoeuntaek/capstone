package com.example.capstone.dto;

import com.example.capstone.entity.User;
import lombok.*;

@AllArgsConstructor
//모든 필드 값을 파라미터로 받는 생성자를 만듦
@NoArgsConstructor
//파라미터가 없는 기본 생성자를 생성
@Getter
@ToString
// 출력할때 간편하게
@Setter

public class UserDto {

    private Long id;
    //    user의 고유 id
    private String user_login_id;
    //user의 login id
    private String user_pass;
    private String user_name;

    public User toEntity() {
//        return new User(id, user_id, user_pass, user_name, null);
        return new User(id, user_login_id, user_pass, user_name);
    }

}