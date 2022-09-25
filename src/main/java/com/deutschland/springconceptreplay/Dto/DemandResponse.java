package com.deutschland.springconceptreplay.Dto;

import com.deutschland.springconceptreplay.Entity.Car;
import com.deutschland.springconceptreplay.Entity.User;
import com.deutschland.springconceptreplay.Enum.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import javax.persistence.ManyToOne;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DemandResponse {

    private String dropUpLoc;

    private String dropOffLoc;

    private String dropUpTime;

    private String dropOffTime;

    private Status status;

    @ManyToOne
    private CarResponse car;

    @ManyToOne
    private UserResponse user;



}
