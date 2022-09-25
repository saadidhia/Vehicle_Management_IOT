package com.deutschland.springconceptreplay.service;

import static java.util.stream.Stream.ofNullable;

import com.deutschland.springconceptreplay.Dto.DemandResponse;
import com.deutschland.springconceptreplay.Entity.Car;
import com.deutschland.springconceptreplay.Entity.Demand;
import com.deutschland.springconceptreplay.Entity.User;
import com.deutschland.springconceptreplay.Repository.CarRepository;
import com.deutschland.springconceptreplay.Repository.DemandRepository;
import com.deutschland.springconceptreplay.Repository.UserRepository;
import com.deutschland.springconceptreplay.mapper.DemandMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;
import org.webjars.NotFoundException;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class DemandService {

    @Autowired
    private DemandRepository demandRepository;
    private final UserRepository userRepository;
    private final CarRepository carRepository;
    private final DemandMapper demandMapper;

    @Transactional
    public Demand addDemand(UUID userId, UUID carId, Demand demandRequest) {
        User user = userRepository.findById(userId).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.BAD_REQUEST,
                        "User not found.")
        );
        Car car = carRepository.findById(carId).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.BAD_REQUEST,
                        "Car not found.")
        );
        demandRequest.setUser(user);
        demandRequest.setCar(car);
        System.out.println(car);
        System.out.println(demandRequest);

        return demandRepository.save(demandRequest);

    }

    public DemandResponse findDemandForSpecificCarAndUser(UUID userId, UUID carId) {
        User user = userRepository.findById(userId).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.BAD_REQUEST,
                        "User not found."));
        Car car = carRepository.findById(carId).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.BAD_REQUEST,
                        "Car not found.")
        );

       Demand demand= demandRepository.findDemandByCarAndUser(car, user);

      return  ofNullable(demand).map(demandMapper::demandToDemandResponse).findFirst()
                                .orElseThrow(  () -> new NotFoundException(
                                        String.format("No Such Demand Found for car with Id %s and user with Id %s",
                                                carId,userId)));

    }

    public List<DemandResponse> getDemands() {
        return demandRepository.findAll()
                               .stream()
                               .map(demandMapper::demandToDemandResponse)
                               .collect(Collectors.toList());
    }

}
