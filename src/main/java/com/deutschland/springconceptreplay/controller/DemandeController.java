package com.deutschland.springconceptreplay.controller;

import com.deutschland.springconceptreplay.Dto.DemandResponse;
import com.deutschland.springconceptreplay.Entity.Car;
import com.deutschland.springconceptreplay.Entity.Demand;
import com.deutschland.springconceptreplay.Entity.User;
import com.deutschland.springconceptreplay.service.CarService;
import com.deutschland.springconceptreplay.service.DemandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value="/api/v1/demands")
public class DemandeController {

    @Autowired
    private DemandService demandService;

    @PostMapping("users/{userId}/cars/{carId}")
    @ResponseBody
    public Demand create(@PathVariable("userId") UUID userId, @PathVariable("carId") UUID carId,
            @RequestBody Demand demand){

        return demandService.addDemand(userId,carId,demand) ;

    }

    @GetMapping("users/{userId}/cars/{carId}")
    @ResponseBody
    public DemandResponse findDemandByCarAndUser(@PathVariable("userId") UUID userId,@PathVariable("carId") UUID carId){
        return demandService.findDemandForSpecificCarAndUser(userId,carId);
    }

    @GetMapping
    @ResponseBody
    public List<DemandResponse> getAllDemands(){
      return  demandService.getDemands();

    }

}
