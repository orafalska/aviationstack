package com.aviation.rest.webservices.restfulwebservices;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;

import com.aviation.rest.webservices.restfulwebservices.model.Airport;
import com.aviation.rest.webservices.restfulwebservices.model.Airports;

public class AirportService {
	public static final Logger log = LoggerFactory.getLogger(AirportService.class);//Logger.getLogger(AirportService.class.getName());
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
			log.error(e.getMessage(), e);
			
		}

		return airports;

	}
}
