package com.deutschland.springconceptreplay.Repository;

import com.deutschland.springconceptreplay.Entity.Car;
import com.deutschland.springconceptreplay.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;


@Repository
public interface CarRepository extends JpaRepository<Car, UUID> {

}
