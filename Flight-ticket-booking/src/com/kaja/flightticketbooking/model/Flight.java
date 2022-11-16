package com.kaja.flightticketbooking.model;

public class Flight {
	private int flightId;
	private String flightName;
	private String source;
	private String destination;
	private int numberOfSeats;
	private String date;
	private String depatureTime;
	private String arrivalTime;
	private String flightClass;
	private int travelFare;

	public int getFlightId() {
		return flightId;
	}

	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public int getNumberOfSeats() {
		return numberOfSeats;
	}

	public void setNumberOfSeats(int numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getFlightClass() {
		return flightClass;
	}

	public void setFlightClass(String flightClass) {
		this.flightClass = flightClass;
	}

	public String getFlightName() {
		return flightName;
	}

	public void setFlightName(String flightName) {
		this.flightName = flightName;
	}

	public int getTravelFare() {
		return travelFare;
	}

	public void setTravelFare(int travelFare) {
		this.travelFare = travelFare;
	}

	public String getDepatureTime() {
		return depatureTime;
	}

	public void setDepaturetime(String depaturetime) {
		this.depatureTime = depaturetime;
	}

	public String getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

}
