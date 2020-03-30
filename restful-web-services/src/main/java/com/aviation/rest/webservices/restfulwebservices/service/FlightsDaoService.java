package com.aviation.rest.webservices.restfulwebservices.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.aviation.rest.webservices.restfulwebservices.model.FlightList;



@Component
public class FlightsDaoService {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${api.key}")
	private String apiKey;
	
	
	public FlightList getAllFlights(){
		
		FlightList response = restTemplate.getForObject(
				"http://api.aviationstack.com/v1/flights"+"?access_key="+apiKey, FlightList.class );
//		List<AirlineRoute> airlineRoute = response.findAll();
				response.getone();
		
		//flightList.addAll(response);
		
		return response;
		
	}

}
