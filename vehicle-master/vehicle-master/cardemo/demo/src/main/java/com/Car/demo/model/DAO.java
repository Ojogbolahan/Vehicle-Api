package com.Car.demo.model;


import lombok.*;
//no argsconstructor
@NoArgsConstructor
@Data
public class DAO {
    private String responseMessage;

    private Vehicle vehicle;

    public DAO(String responseMessage, Vehicle vehicle) {
        this.responseMessage = responseMessage;
        this.vehicle = vehicle;
    }

   public String getResponseMessage() {
        return responseMessage;
     }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}
