package com.example.capstone.service;

import com.example.capstone.entity.Group_tbl;
import com.example.capstone.entity.Schedule;
import com.example.capstone.entity.User;
import com.example.capstone.repository.GroupRepository;
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

    @Autowired
    private GroupRepository groupRepository;


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

    public Schedule UpdateScheduleWithGroup(Long group_id, Long schedule_id, Long user_id) {
        Schedule found = scheduleRepository.findByGroup_idAndUser_id(user_id, group_id);

        //schedule의 group이 이미 있다면
        if (found != null) {
            found.setGroup_tbl(null);
            scheduleRepository.save(found);
        }

        Schedule schedule = scheduleRepository.findById(schedule_id).orElse(null);
        Group_tbl group_tbl = groupRepository.findById(group_id).orElse(null);
        schedule.setGroup_tbl(group_tbl);
        return scheduleRepository.save(schedule);

    }

    public Schedule GetScheduleWithGroup(Long user_id, Long group_id) {
        //scheduleDB에서 group id, user id로 schedule 찾기
        Schedule schedule = scheduleRepository.findByGroup_idAndUser_id(group_id, user_id);
        return schedule;


    }

    public List<Schedule> GetScheduleListWithGroup(Long group_id) {
        //scheduleDB에서 group id로 schedule 찾기
        List<Schedule> schedule_list = scheduleRepository.findByGroup_id(group_id);
        return schedule_list;
    }

    public Schedule DeleteSchedule(Long schedule_id) {
        Schedule schedule = scheduleRepository.findById(schedule_id).orElse(null);
        scheduleRepository.delete(schedule);
        return schedule;
    }
}