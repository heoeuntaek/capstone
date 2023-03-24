package com.example.capstone.repository;

import com.example.capstone.entity.Group_tbl;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface GroupRepository extends CrudRepository<Group_tbl, Long> {

    @Query(value = "SELECT * FROM group_tbl WHERE group_code = :group_code", nativeQuery = true)
    Group_tbl findByGroup_code(@Param("group_code") String group_code);
}