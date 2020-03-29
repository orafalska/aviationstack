package com.aviation.rest.webservices.restfulwebservices.controller;

import java.util.List;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aviation.rest.webservices.restfulwebservices.AirportService;
import com.aviation.rest.webservices.restfulwebservices.model.Airport;
import com.aviation.rest.webservices.restfulwebservices.model.Airports;
import com.aviation.rest.webservices.restfulwebservices.service.RestService;

@RestController
public class AirportController {

	AirportService airportService = new AirportService();

	@GetMapping(path = "/")

	public String Airports() {

		return "Hello! To get airoports, please go to http://localhost:8080/airports";
	}

	@GetMapping(path = "/airports")
	public ResponseEntity<Object> getAirports() {
		List<Airport> allAirports = airportService.getAirports();
		if (allAirports.isEmpty()) {

			return new ResponseEntity<>("Nothing found.", HttpStatus.UNAUTHORIZED);
		}
		return new ResponseEntity<>(allAirports, HttpStatus.OK);
	}
}
