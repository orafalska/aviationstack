package com.aviation.rest.webservices.restfulwebservices;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.client.RestTemplate;

import com.aviation.rest.webservices.restfulwebservices.model.Airport;
import com.aviation.rest.webservices.restfulwebservices.model.Airports;

public class AirportService {
	
//	@Value("${apiKey}")
//	private String apiKey;
	
	private static final String API_AIRPORTS = "http://api.aviationstack.com/v1/airports?access_key=";
    private String apiKey = "64f0403188f63f4b9f52d3489cb6c955";
	public List<Airport> getAirports() {
		List<Airport> airports = new ArrayList<>();
		RestTemplate restTemplate = new RestTemplate();

		try {

			final String uriAirports = API_AIRPORTS + apiKey;
			Airports airport = restTemplate.getForObject(uriAirports, Airports.class);
			airports.addAll(airport.getAirports());

		} catch (Exception e) {
			//log.error(e.getMessage());
		}

		return airports;

	}
}
