package com.Car.demo.repository;

import org.slf4j.Logger;
import com.Car.demo.model.Vehicle;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


//Adding comments to the code for test purposes
//This is the repository interface for Vehicle entity
@Repository
    public interface VehicleRepository extends JpaRepository<Vehicle, Long > {


    List<Vehicle> findByName(String name);
    List<Vehicle> findByType(String type);



    }


