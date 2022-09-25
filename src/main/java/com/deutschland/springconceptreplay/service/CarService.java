package com.deutschland.springconceptreplay.service;

import static java.util.Optional.ofNullable;

import com.deutschland.springconceptreplay.Entity.Car;
import com.deutschland.springconceptreplay.Entity.Demand;
import com.deutschland.springconceptreplay.Enum.StatusCar;
import com.deutschland.springconceptreplay.Repository.CarRepository;
import com.deutschland.springconceptreplay.Repository.DemandRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class CarService {


    private final DemandRepository demandRepository;
    private final CarRepository carRepository;


    public Car addCar(Car car)  {
        return ofNullable(car).map(carRepository::save)
                                   .orElseThrow(()->{
                                       log.error("cannot create car"+car);
                                       return new ResponseStatusException(HttpStatus.BAD_REQUEST,"Cannot create "
                                               + "Car!");
                                   });


    }

    public Optional<Car> updateCar (UUID id) {
        return carRepository.findById(id).map(carRepository::save);
    }

        public void deleteCar(UUID id){
             carRepository.deleteById(id);
        }

    /**
     * change location for specific car
     * @param id id of car
     * @param location the new location
     * @return then car that has changed
     */
    public Car changeLocation(UUID id, String location) {
        Car carFounded=carRepository.findById(id).get();
        carFounded.setCurrentLoc(location);
       return carRepository.save(carFounded);

    }

    public Car changeStatus(UUID id) {
        Car car = carRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST,
                "Cannot find Car with this id = " + id));
        List<Demand> demands = demandRepository.findByCarId(id);
        if (demands.size() == 0) {
            car.setStatusCar(StatusCar.DISPO);
            carRepository.save(car);

        } else {
            car.setStatusCar(StatusCar.NODISPO);
            carRepository.save(car);
        }
        return car;
    }





}


