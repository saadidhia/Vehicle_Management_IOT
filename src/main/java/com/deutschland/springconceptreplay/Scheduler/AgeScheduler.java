package com.deutschland.springconceptreplay.Scheduler;

import com.deutschland.springconceptreplay.Entity.User;
import com.deutschland.springconceptreplay.Repository.UserRepository;
import com.deutschland.springconceptreplay.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Slf4j
@Service
public class AgeScheduler {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService;

    public void changeAge(){
        int dayOfToday=LocalDate.now().getDayOfMonth();
        int monthOfToday=LocalDate.now().getMonth().getValue();
        List<UUID> usersId=userRepository.findMonthAndDayOfUsers(dayOfToday,monthOfToday);
        userService.modifyCertainUserAges(usersId);



    }


    @Scheduled(cron ="0 20 0 * * *")
    public void schedule() {
        changeAge();
    }



}
