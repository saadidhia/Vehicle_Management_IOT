package com.deutschland.springconceptreplay.controller;

import com.deutschland.springconceptreplay.Entity.Car;
import com.deutschland.springconceptreplay.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(value="/api/v1/car")
public class carController {


    @Autowired
    private CarService carService;

    @PostMapping
    @ResponseBody
    public Car create(@RequestBody Car car ){
        return carService.addCar(car) ;

    }

    @PatchMapping("/{id}")
    @ResponseBody
    public Optional<Car> update(@PathVariable("id") UUID id){
        return carService.updateCar(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") UUID id){
        carService.deleteCar(id);
    }

    @PutMapping("/{id}")
    @ResponseBody
    public Car changeLocation(@PathVariable("id") UUID id, @RequestParam String location){
        return carService.changeLocation(id,location);

    }

    @PostMapping("/status/{id}")
    @ResponseBody
    public Car changeStatus (@PathVariable("id") UUID id ){
        return carService.changeStatus( id );
    }




}


