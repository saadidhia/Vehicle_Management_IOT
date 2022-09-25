package com.deutschland.springconceptreplay.Dto;

import com.deutschland.springconceptreplay.Enum.StatusCar;
import lombok.Data;


@Data
public class CarResponse {


    private String model;

    private String engine;

    private String infoSystem;

    private String interiorDesign;

    private String currentLoc;

    private StatusCar statusCar;
}
