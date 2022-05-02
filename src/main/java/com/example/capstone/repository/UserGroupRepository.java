package com.example.capstone.repository;

import com.example.capstone.entity.Group_tbl;
import com.example.capstone.entity.User_group;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserGroupRepository extends CrudRepository<User_group, Long> {

    @Query(value = "SELECT * FROM user_group WHERE user_id = :user_id", nativeQuery = true)
    List<User_group> findByuser_id(@Param("user_id") Long user_id);


    @Query(value = "SELECT * FROM user_group WHERE group_id = :group_id", nativeQuery = true)
    List<User_group> findByGroupId(@Param("group_id") Long group_id);

    @Query(value = "SELECT * FROM user_group WHERE user_id = :user_id AND group_id = :group_id", nativeQuery = true)
    User_group findByuser_idAndGroupId(@Param("user_id") Long user_id, @Param("group_id") Long group_id);




}