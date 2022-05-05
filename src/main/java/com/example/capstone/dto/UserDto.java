package com.example.capstone.dto;

import com.example.capstone.entity.User;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
@Setter

public class UserDto {

    private Long id;
    private String user_login_id;
    private String user_pass;
    private String user_name;

    public User toEntity() {
//        return new User(id, user_id, user_pass, user_name, null);
        return new User(id, user_login_id, user_pass, user_name);
    }

}