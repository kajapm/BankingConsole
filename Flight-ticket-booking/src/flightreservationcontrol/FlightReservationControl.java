package flightreservationcontrol;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import flightreservationmodel.Bookings;
import flightreservationmodel.Flight;
import flightreservationmodel.Passenger;
import flightreservationrepositary.Data;
import flightreservationview.FlightReservationView;

public class FlightReservationControl {
	private FlightReservationView view;
	private Data data = Data.getInstance();
	private int bookingId = 100;

	public FlightReservationControl(FlightReservationView flightReservationView) {
		this.view = flightReservationView;
	}

	public void bookTicket() {
		HashMap<Integer, Flight> flightList = data.getFlightList();
		HashMap<Integer, Flight> availableFlights = new HashMap<Integer, Flight>();
		ArrayList<Passenger> passengerList = new ArrayList<Passenger>();

		view.print("From :");
		String from = view.scanString();

		view.print("From :");
		String to = view.scanString();
		int availableFlightCount = 0;

		for (Map.Entry<Integer, Flight> entry : flightList.entrySet()) {
			if (entry.getValue().getSource().equals(from) && entry.getValue().getDestination().equals(to)) {
				availableFlightCount++;
				availableFlights.put(entry.getKey(), entry.getValue());
			}
		}

		if (availableFlightCount > 0) {
			view.print("Enter train number :");
			int trainId = Integer.parseInt(view.scanString());

			view.print("Enter number of passengers :");
			int passengerCount = Integer.parseInt(view.scanString());

			for (int i = 1; i <= passengerCount; i++) {
				view.println("Enter passenger " + i + " details :\n");

				Passenger passenger = addPassengerDetails();
				data.addPaasengerList(passenger);
				passengerList.add(passenger);

			}

			addBooking(passengerList, trainId);

			view.println("Successfully Booked");
			view.mainMenu();
		}

	}

	private void addBooking(ArrayList<Passenger> passengerList, int trainId) {
		HashMap<Integer, Flight> flightList = data.getFlightList();
		Bookings booking = new Bookings();

		booking.setPNR(bookingId++);
		booking.setFare(flightList.get(trainId).getTravelFare() * passengerList.size());
		booking.setFlight(flightList.get(trainId));
		booking.setPassengerList(passengerList);
		booking.setBookedDate(new Date());
		booking.setStatus("WL");

		data.addBookingList(booking);

		view.printBooking(booking);
	}

	private Passenger addPassengerDetails()

	{
		Passenger passenger = new Passenger();

		view.print("Name :");
		passenger.setName(view.scanString());

		view.print("Age ");
		passenger.setAge(Byte.parseByte(view.scanString()));

		view.print("Gender ");
		passenger.setGender(view.scanString());

		view.print("Passport Number ");
		passenger.setPassportId(view.scanString());

		view.print("Contact Number ");
		passenger.setEmergencyContact(view.scanString());

		view.print("Emergency contact number ");
		passenger.setGender(view.scanString());

		return passenger;
	}

	public void getPNRStatus() {
		ArrayList<Bookings> bookingList = data.getBookingList();
		Bookings booking = null;
		view.print("Enter PNR Number");
		int pnr = Integer.parseInt(view.scanString());

		for (int i = 0; i < bookingList.size(); i++) {
			if (bookingList.get(i).getPNR() == pnr) {
				booking = bookingList.get(i);
			}
		}

		if (booking != null) {
			view.println("Your pnr status : " + booking.getStatus());
		} else {
			view.println("No PNR found.!");
		}
		view.mainMenu();

	}

	public void bookedTickets() {
		ArrayList<Bookings> bookings=new ArrayList<Bookings>();
		view.printBookingList(bookings);
		view.mainMenu();
	}

	public void cancelBooking() {
		view.println("Enter PNR :");
		int pnr=Integer.parseInt(view.scanString());
		ArrayList<Bookings> bookingList=data.getBookingList();
		
		for(int i=0;i<bookingList.size();i++)
		{
			
		}

	}

	public void searchPassenger() {
		// TODO Auto-generated method stub

	}

	public void changeTicketStatus() {
		// TODO Auto-generated method stub

	}

	public void listFlightRoutes() {
		// TODO Auto-generated method stub

	}

	public void addFlightRoute() {
		// TODO Auto-generated method stub

	}

}
