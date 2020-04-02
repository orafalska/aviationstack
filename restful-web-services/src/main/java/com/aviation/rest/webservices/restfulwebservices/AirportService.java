package com.aviation.rest.webservices.restfulwebservices;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.aviation.rest.webservices.restfulwebservices.model.Airport;
import com.aviation.rest.webservices.restfulwebservices.model.Airports;

@RestController
public class AirportService {
	public static final Logger LOG = LoggerFactory.getLogger(AirportService.class);

//	@Value("${api.key}")
//	private String apiKey;

	int id = 0;
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
			LOG.error(e.getMessage(), e);

		}

		return airports;

	}

	public Airport findAirport(int id) {
		try {
			RestTemplate restTemplate = new RestTemplate();
			Airports response = restTemplate.getForObject(API_AIRPORTS + apiKey, Airports.class);

			for (Airport airport : response.getAirports()) {
				System.out.println(airport.toString());
				
				if (airport.getId() == id) {

					return airport;
				}
			}
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);

		}
		System.out.println("Flight could not be found");
		return null;

	}

	public Airport saveAirport(Airport airport) {
		RestTemplate restTemplate = new RestTemplate();
		airport.setId((++id));
		Airports response = restTemplate.getForObject(API_AIRPORTS + apiKey, Airports.class);

		System.out.println(airport.toString());
		try {
			response.addAirport(airport);
		} catch (Exception e) {
			System.out.println("Airport has not been added");
			LOG.error(e.getMessage(), e);
		}
		return airport;
	}
}
