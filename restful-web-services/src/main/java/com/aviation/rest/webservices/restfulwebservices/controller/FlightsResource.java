package com.aviation.rest.webservices.restfulwebservices.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.aviation.rest.webservices.restfulwebservices.exceptions.FlightNotFoundException;
import com.aviation.rest.webservices.restfulwebservices.model.Flight;
import com.aviation.rest.webservices.restfulwebservices.model.FlightList;
import com.aviation.rest.webservices.restfulwebservices.service.FlightsDaoService;




@RestController
public class FlightsResource {
	
	@Autowired
	private FlightsDaoService service;
	
	@Cacheable("flights")
	@GetMapping("/flights")
	public FlightList retrieveAllFlights(){
		FlightList flights = service.getAllFlights();
		if (flights==null)
			throw new FlightNotFoundException("Flights were not found");
		
		return flights;
	}
	
	
	@GetMapping("/flights/{number}")
	public Flight retrieveFlightByNumber(@PathVariable int number) {
		Flight flight = service.findFlight(number);
		
		if(flight == null)
			throw new FlightNotFoundException(" Flight with  number: "+number+" could not be found");
		return flight;
	}
	
	@CachePut(value="flights")
	@PostMapping(value="/flights", consumes="application/json")
	public ResponseEntity<Object> createFlight(@Valid @RequestBody Flight flight) {
		Flight savedflight = service.saveFlight(flight);
		//returns status of some operations
		 URI location = ServletUriComponentsBuilder
		.fromCurrentRequest() //will return uri /users
		.path("/{number}") //will return uri {number} //path allows to append something to uri, so basically once we have created a new flight we will show it at once, by getting its number savedFlight.getNestedFlight().getNumber() and showing its "page" /flights/{number}
		.buildAndExpand(savedflight.getNestedFlight().getNumber()).toUri() ;
		 
		 
		return ResponseEntity.created(location).build();

	}


}
