package com.aviation.rest.webservices.restfulwebservices.model;

import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.SQLException;

public class StringBlob {
	int id;
	String flight;

	@Override
	public String toString() {
		return "StringBlob [id=" + id + ", flight=" + flight + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFlight() {
		return flight;
	}

	public void setFlight(String flight) {
		this.flight = flight;
	}
}
