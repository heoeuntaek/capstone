package com.example.capstone.repository;

import com.example.capstone.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;

public interface UserRepository extends CrudRepository<User, Long>  {


    //Iterable<Article> findAll(); // 메소드 오버라이딩
    ArrayList<User> findAll(); //위에것을 아래걸로 바꾸기

    @Query(value =
            "select * " +
                    "from user " +
                    "where user_login_id = :user_login_id",
            nativeQuery = true) //true로 해줘야 해당sql 동작
    User findByUser_login_id(@Param("user_login_id")String user_login_id);


    @Query(value =
            "select * " +
                    "from user " +
                    "where user_name = :user_name",
            nativeQuery = true) //true로 해줘야 해당sql 동작
    User findByuser_name(@Param("user_name")String user_name);
}