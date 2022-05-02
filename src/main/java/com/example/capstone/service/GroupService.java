package com.example.capstone.service;


import com.example.capstone.repository.UserGroupRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Slf4j
@Service

public class GroupService {


    @Autowired
    private UserGroupRepository userGroupRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private GroupService groupService;

//    public void createGroup(GroupDto groupDto) {
//        User user = new User();
//        user.getUser_groups().get(0).getGroup_tbl();
//        Group_tbl group_tbl = new Group_tbl();
//
//        User_group user_group = new User_group();
//        user_group.setGroup_tbl(group_tbl);
//        user_group.setUser(user);
//        user.getUser_groups().get();
//
//
//    }


    private String Create_group_code() {
        int leftLimit = 48; // numeral '0'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();
        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
        System.out.println(generatedString);
        return generatedString;

    }
}