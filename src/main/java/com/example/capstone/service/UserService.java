package com.example.capstone.service;

import com.example.capstone.dto.UserDto;
import com.example.capstone.entity.Group_tbl;
import com.example.capstone.entity.User;
import com.example.capstone.entity.User_group;
import com.example.capstone.repository.GroupRepository;
import com.example.capstone.repository.UserGroupRepository;
import com.example.capstone.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Slf4j
@Service
//@Transactional
public class UserService {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserGroupRepository userGroupRepository;

    @Autowired
    private GroupRepository groupRepository;


    public List<User> findAll() {
        return userRepository.findAll();  //리스트 형태로 반환
    }


    public User findbyId(Long id) {
        log.info("정보 {}", userRepository.findById(id));
        return userRepository.findById(id).orElse(null);  //객체 하나 반환

    }

    public User findByUserLoginid(String user_login_id) {
        log.info("정보 {}", userRepository.findByUser_login_id(user_login_id));
        return userRepository.findByUser_login_id(user_login_id);  //객체 하나 반환
    }


    public User userRegister(UserDto dto) {

        User created = dto.toEntity();
        if (created.getId() != null) {
            throw new IllegalArgumentException("이미 아이디가 있어서 생성할 수 없습니다.");
        }
        return userRepository.save(created);
    }


    public User update(Long id, UserDto dto) {
        //1: 수정용 엔티티 조회 dto -> entity
        User user = dto.toEntity();
        log.info("id : {}, article : {}", id, user.toString());

        // 2:대상 엔티티 조회
        User target = userRepository.findById(id).orElse(null);  //기존에 있던 것

        //3 : 잘못된 요청 처리(id 없거나, id 다른경우

        if (target == null || id != user.getId()) {
            // 400 - 잘못된 요청
            log.info("잘못된 요청! id : {}, article : {}", id, user.toString());
            return null;
        }
        // 4 : 업데이트 및 정상 응답(200)
        target.patch(user); // 기존에 있던것을 붙임
        User updated = userRepository.save(target); //target 저장, target을 업데이트
        return updated;

    }


    public User login(UserDto dto) throws Exception {
        //1: 수정용 엔티티 조회 dto -> entity
        User user = dto.toEntity();

        User user_found = userRepository.findByUser_login_id(user.getUser_login_id());
        if (user_found==null) {
            log.info("id가 없습니다.");


            throw NotFoundException("user not found");


        }

//        입력받은 id
        String user_login_id = user.getUser_login_id();
//        입력받은 비번
        String user_pass = user.getUser_pass();

        // 2:Id를 이용해 db의 비번 조회
        User target = userRepository.findByUser_login_id(user.getUser_login_id());  //기존에 있던 것

        // db비번
        String db_pass = target.getUser_pass();




        if (user != null) {
            if (user_pass.equals(db_pass)) {
                System.out.println("비밀번호가 일치합니다.");
                return user;
            } else {
                System.out.println("비밀번호가 불일치합니다.");
                return null;
            }
        }
        System.out.println("아이디가 없습니다.");
        return null;
    }

    private Exception NotFoundException(String user_not_found) {
        return new Exception(user_not_found);
    }


    public User findByUsername(String user_name) {
        return userRepository.findByuser_name(user_name);
    }

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

    public User_group CreateGroup(Long user_id, Group_tbl group_tbl) {
        User findUser = userRepository.findById(user_id).orElse(null);
        User_group user_group = new User_group();
        String group_code = Create_group_code();
        group_tbl.setGroup_code(group_code);

        user_group.setGroup_tbl(group_tbl);
        user_group.setUser(findUser);
        groupRepository.save(group_tbl);
        return userGroupRepository.save(user_group);
    }

    public User_group updateGroup(Long user_id, String group_code) {
        User findUser = userRepository.findById(user_id).orElse(null);
        Group_tbl findGroup = groupRepository.findByGroup_code(group_code);

        User_group find_user_group = userGroupRepository.findByuser_idAndGroupId(user_id,findGroup.getId());
        if(find_user_group != null){
            return null;
        }

        if (findGroup != null) {
            User_group user_group = new User_group();
            user_group.setUser(findUser);
            user_group.setGroup_tbl(findGroup);
            return userGroupRepository.save(user_group);
        }
        return null;

    }

    public Group_tbl GroupRegister(Group_tbl group_tbl) {
        return groupRepository.save(group_tbl);
    }

    //그룹 리스트 반환
    public List<Group_tbl> GetGroupList(Long user_id) {
        //user_id로 그룹 리스트 조회
        List<User_group> user_groups = userGroupRepository.findByuser_id(user_id);
        List<Group_tbl> group_tbls = new ArrayList<>();
        for (User_group user_group : user_groups) { //그룹리스트에 있는것 하나씩 꺼내오기

            //그룹리스트에 있는 그룹의 id로 그룹 Id조회
            Long group_id = user_group.getGroup_tbl().getId();

            //그룹 id로 그룹 조회
            Group_tbl group_tbl = groupRepository.findById(group_id).orElse(null);

            //그룹 리스트에 추가
            group_tbls.add(group_tbl);
        }
        return group_tbls;


    }


    public List<User> GetUserList(Long group_id) {
        //group_id로 그룹 리스트 조회
        List<User_group> user_groups = userGroupRepository.findByGroupId(group_id);

        log.info("user_groups : {}", user_groups.toString());
        //그룹리스트에 있는 그룹의 id로 그룹 Id조회

        List<User> users = new ArrayList<>();

        for (User_group user_group : user_groups) { //그룹리스트에 있는것 하나씩 꺼내오기
            Long user_id = user_group.getUser().getId();
            log.info("user_id : {}", user_id);

            //user_id로 유저리스트
            User user = userRepository.findById(user_id).orElse(null);
            log.info("user : {}", user);

            users.add(user);
        }
        return users;
    }


    public User_group CreateGroup_dto(Long user_id, Group_tbl group_tbl) {
        User user_found = userRepository.findById(user_id).orElse(null);
        User_group user_group = new User_group();
        user_group.setUser(user_found);
        user_group.setGroup_tbl(group_tbl);
        return userGroupRepository.save(user_group);
    }

    public User_group GetuserGroup(Long user_id, Long group_id) {
        User_group user_group_created = userGroupRepository.findByuser_idAndGroupId(user_id, group_id);
        User user = userRepository.findById(user_id).orElse(null);
        Group_tbl group_tbl = groupRepository.findById(group_id).orElse(null);
        user_group_created.setUser(user);
        user_group_created.setGroup_tbl(group_tbl);
        log.info("user_group_created : {}", user_group_created);
        return user_group_created;
    }

    public User_group DeleteuserGroup(Long user_id, Long group_id) {
        User_group user_group_created = userGroupRepository.findByuser_idAndGroupId(user_id, group_id);
        userGroupRepository.delete(user_group_created);
        return user_group_created;
    }


}

//    public List<User_group> Group_list(Long user_id) {
//        User findUser = userRepository.findById(user_id).orElse(null);
//        List<User_group> user_group = userGroupRepository.findByUser(findUser);
//        return user_group;
//    }