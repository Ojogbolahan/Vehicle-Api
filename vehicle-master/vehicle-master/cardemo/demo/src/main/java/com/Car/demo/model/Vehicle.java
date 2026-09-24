package com.Car.demo.model;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@Data
@Entity
@NoArgsConstructor
@ToString
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private int modelYear;

    private int tyreNumber;
    private String type;



    public Vehicle(String name, int modelYear, int tyreNumber, String type) {
        this.name = name;
        this.modelYear = modelYear;
        this.tyreNumber = tyreNumber;
        this.type = type;
    }





    @Override
    public String toString() {
        return String.format("vehicles{name='%s', modelYear=%d, tyreNumber=%d, type='%s'}",
                name, modelYear, tyreNumber, type);
    }
}
