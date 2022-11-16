package com.kaja.flightticketbooking.repositary;

import java.util.ArrayList;
import com.kaja.flightticketbooking.model.Bookings;
import com.kaja.flightticketbooking.model.Flight;
import com.kaja.flightticketbooking.model.Passenger;

public class FlightReservationDatabase {
	static private FlightReservationDatabase flightReservationDatabase = null;
	private ArrayList<Flight> flightList;
	private ArrayList<Passenger> passengerList;
	private ArrayList<Bookings> bookingList;

	private FlightReservationDatabase() {
		flightList = new ArrayList<Flight>();
		passengerList = new ArrayList<Passenger>();
		bookingList = new ArrayList<Bookings>();
	}

	public void addFlight(Flight flight) {
		flightList.add(flight);
	}

	public static FlightReservationDatabase getInstance() {
		if (flightReservationDatabase == null) {
			flightReservationDatabase = new FlightReservationDatabase();

		}
		return flightReservationDatabase;
	}

	public void setFlightList(ArrayList<Flight> flightList) {
		this.flightList = flightList;
	}

	public void setBookingList(ArrayList<Bookings> bookingList) {
		this.bookingList = bookingList;
	}

	public ArrayList<Flight> getFlightList() {
		return flightList;
	}

	public ArrayList<Passenger> getPassengerList() {
		return passengerList;
	}

	public ArrayList<Bookings> getBookingList() {
		return bookingList;
	}

	public void addPaasengerList(Passenger passenger) {
		passengerList.add(passenger);
	}

	public void addBookingList(Bookings booking) {
		bookingList.add(booking);
	}

}
