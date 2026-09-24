package com.Car.demo;

import com.Car.demo.model.Vehicle;

import com.Car.demo.repository.VehicleRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class VehicleApplication {
	private static final Logger log = LoggerFactory.getLogger(VehicleApplication.class);
@Autowired
VehicleRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(VehicleApplication.class, args);
	}


	@Bean
	CommandLineRunner demo() {
		return args -> {
			Vehicle Tesla = new Vehicle("Tesla Model 3 Highland ", 2027 , 5,"Electric");
			Vehicle Toyota = new Vehicle ("Toyota Land Cruiser Prado",  2027  , 5,"SUV");
			Vehicle Benz= new Vehicle("Mercedes-Benz Actros (Truck)",   2027 ,5,"Truck");

			repository.save(Tesla);
			repository.save(Toyota);
			repository.save(Benz);


			log.info( repository.findAll().toString());

		};
	}
}
