package com.Car.demo.controller;

import com.Car.demo.model.DAO;
import com.Car.demo.model.Vehicle;
import com.Car.demo.repository.VehicleRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

//Adding comments to the code for test purposes
//This is the controller class for handling vehicle-related requests

@RestController
public class VehicleController {

    private static final Logger LOGGER= LoggerFactory.getLogger(VehicleController.class);
    @Autowired
    VehicleRepository repository;

    @GetMapping("/vehicles")
    public List<Vehicle> fetchAllVehicle() {

        return repository.findAll();
    }

    @GetMapping("/vehicles/{id}")
    public ResponseEntity<DAO> getVehicleByID(@PathVariable Long id) {
        Optional<Vehicle> vehicleToFind = repository.findById(id);
        try {
            return new ResponseEntity<>(new DAO("Vehicle found", vehicleToFind.get()), HttpStatus.OK);
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            return new ResponseEntity<>(new DAO("Vehicle not found", null), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(new DAO("An unexpected error occurred: " + e.getMessage(), null), HttpStatus.INTERNAL_SERVER_ERROR);
        }


    }


    @PostMapping("/vehicles")
    public ResponseEntity<DAO> createVehicle(@RequestBody Vehicle vehicle) {
       LOGGER.info("Create Vehicle Request:   {} ",vehicle.toString());
        DAO dao = new DAO("Vehicle created", repository.save(vehicle));
  LOGGER.info("Vehicle created:  {}" , dao );
        return new ResponseEntity<>(dao, HttpStatus.CREATED);
    }


    @PutMapping("/vehicles/{id}")
    public Vehicle updateVehicle(@PathVariable Long id, @RequestBody Vehicle vehicle) {
        Optional<Vehicle> vehicleToUpdate = repository.findById(id);
        if (vehicleToUpdate.isEmpty()) {
            return null;

        } else {

            Vehicle updatedVehicle = vehicleToUpdate.get();
            updatedVehicle.setTyreNumber(vehicle.getTyreNumber());
            updatedVehicle.setType(vehicle.getType());
            updatedVehicle.setName(vehicle.getName());
            updatedVehicle.setModelYear(vehicle.getModelYear());

            return repository.save(updatedVehicle);

        }


    }


    @DeleteMapping("/vehicles/{id}")
    public ResponseEntity<DAO> deleteVehicle(@PathVariable Long id) {
        Optional<Vehicle> vehicleToDelete = repository.findById(id);
        if (vehicleToDelete.isEmpty()) {
            return null;
        } else {
            Vehicle deletedVehicle = vehicleToDelete.get();
            repository.delete(deletedVehicle);
            DAO dao = new DAO("Vehicle deleted successfully", deletedVehicle);
            return new ResponseEntity<>(dao, HttpStatus.OK);
        }

    }
}