package com.deutschland.springconceptreplay.Dto;

import com.deutschland.springconceptreplay.Enum.Gender;
import lombok.Data;

import java.time.LocalDate;

@Data
public class UserResponse {

    private String name;


    private Gender gender;

    private int age;


    private LocalDate birthDate;

}
