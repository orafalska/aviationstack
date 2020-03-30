package com.aviation.rest.webservices.restfulwebservices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aviation.rest.webservices.restfulwebservices.model.FlightList;
import com.aviation.rest.webservices.restfulwebservices.service.FlightsDaoService;



@RestController
public class FlightsResource {
	
	@Autowired
	private FlightsDaoService service;
	
	
	@GetMapping("/flights")
	public FlightList retrieveAllFlights(){
		
		return service.getAllFlights();
	}

}
