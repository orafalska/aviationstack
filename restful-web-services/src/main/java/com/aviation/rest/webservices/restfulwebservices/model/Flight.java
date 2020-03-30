package com.aviation.rest.webservices.restfulwebservices.model;

import java.sql.Date;

import javax.annotation.sql.DataSourceDefinition;

import com.fasterxml.jackson.annotation.JsonFormat;
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
	@JsonProperty("number")
	private String number;
	private String iata;
	private String icao;
	private String codeshared;
	@JsonProperty("aircraft")
	private Aircraft aircraft;
	@JsonProperty("live")
	private Live live;
	
	
	public Flight() {
		super();
	}

	public Flight(String flight_date, String flight_status, DepartureArrival departure, DepartureArrival arrival,
			Airline airline, String number, String iata, String icao, String codeshared, Aircraft aircraft, Live live) {
		super();
		this.flight_date = flight_date;
		this.flight_status = flight_status;
		this.departure = departure;
		this.arrival = arrival;
		this.airline = airline;
		this.number = number;
		this.iata = iata;
		this.icao = icao;
		this.codeshared = codeshared;
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

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getIata() {
		return iata;
	}

	public void setIata(String iata) {
		this.iata = iata;
	}

	public String getIcao() {
		return icao;
	}

	public void setIcao(String icao) {
		this.icao = icao;
	}

	public String getCodeshared() {
		return codeshared;
	}

	public void setCodeshared(String codeshared) {
		this.codeshared = codeshared;
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
//
//public class Flight {
//	
//	@JsonFormat(pattern="YYYY-MM-DD")
//	private Date flight_date;
//	private String flight_status;
//	private String dep_iata;
//	private String arr_iata;
//	private String dep_icao;
//	private String arr_icao;
//	private String airline_name;
//	private String airline_iata;
//	private String airline_icao;
//	private String flight_number;
//	private String flight_iata;
//	private String flight_icao;
//	private String min_delay_dep;
//	private String min_delay_arr;
//	private String max_delay_dep;
//	private String max_delay_arr;
//	
//	
//	
//	public Flight() {
//		super();
//	}
//
//
//
//	public Flight(Date flight_date, String flight_status, String dep_iata, String arr_iata, String dep_icao,
//			String arr_icao, String airline_name, String airline_iata, String airline_icao, String flight_number,
//			String flight_iata, String flight_icao, String min_delay_dep, String min_delay_arr, String max_delay_dep,
//			String max_delay_arr) {
//		super();
//		this.flight_date = flight_date;
//		this.flight_status = flight_status;
//		this.dep_iata = dep_iata;
//		this.arr_iata = arr_iata;
//		this.dep_icao = dep_icao;
//		this.arr_icao = arr_icao;
//		this.airline_name = airline_name;
//		this.airline_iata = airline_iata;
//		this.airline_icao = airline_icao;
//		this.flight_number = flight_number;
//		this.flight_iata = flight_iata;
//		this.flight_icao = flight_icao;
//		this.min_delay_dep = min_delay_dep;
//		this.min_delay_arr = min_delay_arr;
//		this.max_delay_dep = max_delay_dep;
//		this.max_delay_arr = max_delay_arr;
//	}
//
//
//
//	public Date getFlight_date() {
//		return flight_date;
//	}
//
//
//
//	public void setFlight_date(Date flight_date) {
//		this.flight_date = flight_date;
//	}
//
//
//
//	public String getFlight_status() {
//		return flight_status;
//	}
//
//
//
//	public void setFlight_status(String flight_status) {
//		this.flight_status = flight_status;
//	}
//
//
//
//	public String getDep_iata() {
//		return dep_iata;
//	}
//
//
//
//	public void setDep_iata(String dep_iata) {
//		this.dep_iata = dep_iata;
//	}
//
//
//
//	public String getArr_iata() {
//		return arr_iata;
//	}
//
//
//
//	public void setArr_iata(String arr_iata) {
//		this.arr_iata = arr_iata;
//	}
//
//
//
//	public String getDep_icao() {
//		return dep_icao;
//	}
//
//
//
//	public void setDep_icao(String dep_icao) {
//		this.dep_icao = dep_icao;
//	}
//
//
//
//	public String getArr_icao() {
//		return arr_icao;
//	}
//
//
//
//	public void setArr_icao(String arr_icao) {
//		this.arr_icao = arr_icao;
//	}
//
//
//
//	public String getAirline_name() {
//		return airline_name;
//	}
//
//
//
//	public void setAirline_name(String airline_name) {
//		this.airline_name = airline_name;
//	}
//
//
//
//	public String getAirline_iata() {
//		return airline_iata;
//	}
//
//
//
//	public void setAirline_iata(String airline_iata) {
//		this.airline_iata = airline_iata;
//	}
//
//
//
//	public String getAirline_icao() {
//		return airline_icao;
//	}
//
//
//
//	public void setAirline_icao(String airline_icao) {
//		this.airline_icao = airline_icao;
//	}
//
//
//
//	public String getFlight_number() {
//		return flight_number;
//	}
//
//
//
//	public void setFlight_number(String flight_number) {
//		this.flight_number = flight_number;
//	}
//
//
//
//	public String getFlight_iata() {
//		return flight_iata;
//	}
//
//
//
//	public void setFlight_iata(String flight_iata) {
//		this.flight_iata = flight_iata;
//	}
//
//
//
//	public String getFlight_icao() {
//		return flight_icao;
//	}
//
//
//
//	public void setFlight_icao(String flight_icao) {
//		this.flight_icao = flight_icao;
//	}
//
//
//
//	public String getMin_delay_dep() {
//		return min_delay_dep;
//	}
//
//
//
//	public void setMin_delay_dep(String min_delay_dep) {
//		this.min_delay_dep = min_delay_dep;
//	}
//
//
//
//	public String getMin_delay_arr() {
//		return min_delay_arr;
//	}
//
//
//
//	public void setMin_delay_arr(String min_delay_arr) {
//		this.min_delay_arr = min_delay_arr;
//	}
//
//
//
//	public String getMax_delay_dep() {
//		return max_delay_dep;
//	}
//
//
//
//	public void setMax_delay_dep(String max_delay_dep) {
//		this.max_delay_dep = max_delay_dep;
//	}
//
//
//
//	public String getMax_delay_arr() {
//		return max_delay_arr;
//	}
//
//
//
//	public void setMax_delay_arr(String max_delay_arr) {
//		this.max_delay_arr = max_delay_arr;
//	}
//	
//	@Override
//	public String toString() {
//		return "Flight [flight_date=" + flight_date + ", flight_status=" + flight_status 
//				+ ", dep_iata=" + dep_iata + ", arr_iata=" + arr_iata+ ", dep_icao=" + dep_icao + ", arr_icao=" + arr_icao
//				+", airline_name=" + airline_name + ", airline_iata=" + airline_iata + ", airline_icao=" + airline_icao 
//				+ ", flight_number=" + flight_number + ", flight_iata=" + ", flight_iata=" + flight_iata +", flight_icao=" + flight_icao 
//				+ ", min_delay_dep=" + min_delay_dep + ", min_delay_arr=" + min_delay_dep + ", max_delay_dep=" + min_delay_dep + ", max_delay_arr="+ min_delay_dep + "]";
//	}
//	
//	
//}
