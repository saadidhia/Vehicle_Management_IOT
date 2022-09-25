package com.deutschland.springconceptreplay.mapper;

import com.deutschland.springconceptreplay.Dto.CarResponse;
import com.deutschland.springconceptreplay.Dto.DemandResponse;
import com.deutschland.springconceptreplay.Dto.UserResponse;
import com.deutschland.springconceptreplay.Entity.Car;
import com.deutschland.springconceptreplay.Entity.Demand;
import com.deutschland.springconceptreplay.Entity.User;
import org.springframework.stereotype.Component;

@Component
public class DemandMapper {

    public DemandResponse demandToDemandResponse(Demand demand) {

        DemandResponse demandResponse = new DemandResponse();

        demandResponse.setDropOffLoc(demand.getDropOffLoc());
        demandResponse.setDropOffTime(demand.getDropOffTime());
        demandResponse.setDropUpLoc(demand.getDropUpLoc());
        demandResponse.setDropUpTime(demand.getDropUpTime());
        demandResponse.setStatus(demand.getStatus());
        demandResponse.setUser(this.mapUserToUserResponse(demand.getUser()));
        demandResponse.setCar(this.mapCarToCarResponse(demand.getCar()));
        return demandResponse;

    }
    UserResponse mapUserToUserResponse(User user){
        UserResponse userResponse=new UserResponse();

        userResponse.setName(user.getName());
        userResponse.setAge(user.getAge());
        userResponse.setGender(user.getGender());
        userResponse.setBirthDate(user.getBirthDate());

        return userResponse;


    }

    CarResponse mapCarToCarResponse(Car car){
        CarResponse carResponse=new CarResponse();

        carResponse.setEngine(car.getEngine());
        carResponse.setCurrentLoc(car.getCurrentLoc());
        carResponse.setModel(car.getModel());
        carResponse.setInteriorDesign(car.getInteriorDesign());
        carResponse.setStatusCar(car.getStatusCar());
        carResponse.setInfoSystem(car.getInfoSystem());

        return carResponse;

    }

}
