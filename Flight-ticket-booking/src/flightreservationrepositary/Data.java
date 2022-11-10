package flightreservationrepositary;

import java.util.ArrayList;
import java.util.HashMap;

import flightreservationmodel.Bookings;
import flightreservationmodel.Flight;
import flightreservationmodel.Passenger;

public class Data {
	static private Data data = null;
	HashMap<Integer,Flight> flightList;
	ArrayList<Passenger> passengerList;
	ArrayList<Bookings> bookingList;

	private Data() {
		flightList = new HashMap<Integer,Flight>();
		passengerList = new ArrayList<Passenger>();
		bookingList = new ArrayList<Bookings>();
	}

	public static Data getInstance() {
		if (data == null) {
			data = new Data();
		}
		return data;
	}

	public HashMap<Integer,Flight> getFlightList() {
		return flightList;
	}

	public ArrayList<Passenger> getPassengerList() {
		return passengerList;
	}

	public ArrayList<Bookings> getBookingList() {
		return bookingList;
	}
	
	public void addPaasengerList(Passenger passenger)
	{
		passengerList.add(passenger);
	}
	
	public void addBookingList(Bookings booking)
	{
		bookingList.add(booking);
	}

}
