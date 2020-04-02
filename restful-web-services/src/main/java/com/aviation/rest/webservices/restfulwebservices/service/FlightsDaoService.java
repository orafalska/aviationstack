package com.aviation.rest.webservices.restfulwebservices.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.aviation.rest.webservices.restfulwebservices.model.Flight;
import com.aviation.rest.webservices.restfulwebservices.model.FlightList;



@Component
public class FlightsDaoService {
	int number=111000;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${api.key}")
	private String apiKey;
	private FlightList response;
	

	public FlightList getAllFlights(){
		
		response = restTemplate.getForObject(
				"http://api.aviationstack.com/v1/flights"+"?access_key="+apiKey, FlightList.class );

		
		return response;
	}
	
	
	public Flight findFlight(int number) {
		response = restTemplate.getForObject(
				"http://api.aviationstack.com/v1/flights"+"?access_key="+apiKey, FlightList.class );
		
		for(Flight flight : response.getFlightList()) {
			if (Integer.parseInt(flight.getNestedFlight().getNumber())==number) {
				
				return flight;
			}
		}
//		System.out.println("Flight could not be found");
		return null;
	}
	

	public Flight saveFlight(Flight flight) {
		flight.getNestedFlight().setNumber(Integer.toString(++number));
		response = restTemplate.getForObject(
				"http://api.aviationstack.com/v1/flights"+"?access_key="+apiKey, FlightList.class );
		

		try {
			response.addFlight(flight);
		}catch (Exception e) {
			System.out.println("Fligth has not been added");
		}
		return flight;
	}

}
