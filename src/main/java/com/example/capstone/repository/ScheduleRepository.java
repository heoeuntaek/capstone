package com.example.capstone.repository;

import com.example.capstone.entity.Schedule;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ScheduleRepository extends CrudRepository<Schedule, Long> {
    @Query(value = "SELECT * FROM schedule WHERE user_id = :user_id", nativeQuery = true)
    List<Schedule> findByUser_id(@Param("user_id") Long user_id);
}