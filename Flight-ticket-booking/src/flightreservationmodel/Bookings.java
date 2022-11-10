package flightreservationmodel;

import java.util.Date;
import java.util.ArrayList;

public class Bookings {
	private int PNR;
	private double fare;
	private Flight flight;
	private ArrayList<Passenger> passengerList;
	private Date bookedDate;
	private String status;

	public int getPNR() {
		return PNR;
	}

	public void setPNR(int pnr) {
		PNR = pnr;
	}

	public double getFare() {
		return fare;
	}

	public void setFare(double fare) {
		this.fare = fare;
	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	public ArrayList<Passenger> getPassengerList() {
		return passengerList;
	}

	public void setPassengerList(ArrayList<Passenger> passengerList) {
		this.passengerList = passengerList;
	}

	public Date getBookedDate() {
		return bookedDate;
	}

	public void setBookedDate(Date date) {
		this.bookedDate = date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
