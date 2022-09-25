package com.deutschland.springconceptreplay.Repository;

import com.deutschland.springconceptreplay.Dto.DemandResponse;
import com.deutschland.springconceptreplay.Entity.Car;
import com.deutschland.springconceptreplay.Entity.Demand;
import com.deutschland.springconceptreplay.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface DemandRepository extends JpaRepository<Demand, UUID> {

   List<Demand> findByCarId(UUID carId);
   Demand findDemandByCarAndUser(Car car, User userId);

}
