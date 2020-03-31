package com.aviation.rest.webservices.restfulwebservices.model;

import java.sql.Date;

import javax.annotation.sql.DataSourceDefinition;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Flight {
	
	private String flight_date;
	private String flight_status;
	@JsonProperty("departure")
	private DepartureArrival departure;
	@JsonProperty("arrival")
	private DepartureArrival arrival;
	@JsonProperty("airline")
	private Airline airline;
	@JsonProperty("flight")
	private NestedFlight nestedFlight;
	@JsonIgnore
	private Aircraft aircraft;
	@JsonIgnore
	private Live live;

	
	public Flight() {
		super();
	}

	public Flight(String flight_date, String flight_status, DepartureArrival departure, DepartureArrival arrival,
			Airline airline, NestedFlight flight, Aircraft aircraft, Live live) {
		super();
		this.flight_date = flight_date;
		this.flight_status = flight_status;
		this.departure = departure;
		this.arrival = arrival;
		this.airline = airline;
		this.nestedFlight = flight;
		this.aircraft = aircraft;
		this.live = live;
	}


	public String getFlight_date() {
		return flight_date;
	}

	public void setFlight_date(String flight_date) {
		this.flight_date = flight_date;
	}

	public String getFlight_status() {
		return flight_status;
	}

	public void setFlight_status(String flight_status) {
		this.flight_status = flight_status;
	}

	public DepartureArrival getDeparture() {
		return departure;
	}

	public void setDeparture(DepartureArrival departure) {
		this.departure = departure;
	}

	public DepartureArrival getArrival() {
		return arrival;
	}

	public void setArrival(DepartureArrival arrival) {
		this.arrival = arrival;
	}

	public Airline getAirline() {
		return airline;
	}

	public void setAirline(Airline airline) {
		this.airline = airline;
	}

	public NestedFlight getNestedFlight() {
		return nestedFlight;
	}

	public void setNestedFlight(NestedFlight flight) {
		this.nestedFlight = flight;
	}

	public Aircraft getAircraft() {
		return aircraft;
	}

	public void setAircraft(Aircraft aircraft) {
		this.aircraft = aircraft;
	}

	public Live getLive() {
		return live;
	}

	public void setLive(Live live) {
		this.live = live;
	}


	@Override
	public String toString() {
		return "Flight [flight_date=" + flight_date + ", flight_status=" + flight_status 
				+ ", departure:[\n" + " " + ", airport=" + departure.getActual()+ ", timezone=" + departure.getTimezone() + ", iata=" + departure.getIata() + ", icao=" + departure.getIcao() + ", terminal=" + departure.getTerminal()+ ", gate=" + departure.getGate() + ", delay=" + departure.getDelay() 
				+", scheduled=" + departure.getScheduled() + ", estimated=" + departure.getEstimated() + ", actual=" + departure.getActual() 
				+ ", estimated_runway=" + departure.getEstimated_runway() + ", actual_runway=" + departure.getActual_runway()  + "]"+"]";
	}
	
}