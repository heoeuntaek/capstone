package com.example.capstone.service;

import com.example.capstone.entity.Schedule;
import com.example.capstone.entity.User;
import com.example.capstone.repository.ScheduleRepository;
import com.example.capstone.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ScheduleService {

    @Autowired
    private ScheduleRepository scheduleRepository;

    @Autowired
    private UserRepository userRepository;


    public Schedule CreateSchedule(Long user_id, Schedule schedule) {
        User user_found = userRepository.findById(user_id).orElse(null);
        schedule.setUser(user_found);
        return scheduleRepository.save(schedule);

    }

    public Schedule GetSchedule(Long user_id, Long schedule_id) {
        User user_found = userRepository.findById(user_id).orElse(null);
        Schedule schedule_found = scheduleRepository.findById(schedule_id).orElse(null);
        schedule_found.setUser(user_found);
        return schedule_found;

    }

    public List<Schedule> GetScheduleList(Long user_id) {

        User user_found = userRepository.findById(user_id).orElse(null);

        //user_id 1개의 대한 그룹들
        List<Schedule> schedule_list = scheduleRepository.findByUser_id(user_id);

        return schedule_list;

    }
}