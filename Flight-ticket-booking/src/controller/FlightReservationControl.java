package controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import model.Bookings;
import model.Flight;
import model.Passenger;
import repositary.FlightReservationDatabase;
import view.FlightReservationView;

public class FlightReservationControl {
	private FlightReservationView view;
	private FlightReservationDatabase data = FlightReservationDatabase.getInstance();
	private int bookingId = 100;

	public FlightReservationControl(FlightReservationView flightReservationView) {
		this.view = flightReservationView;
	}

	public void bookTicket() {

		ArrayList<Flight> flightList = data.getFlightList();
		ArrayList<Flight> availableFlights = new ArrayList<Flight>();
		ArrayList<Passenger> passengerList = new ArrayList<Passenger>();

		view.showMessage("From :");
		String from = view.scanString();

		view.showMessage("To :");
		String to = view.scanString();
		int availableFlightCount = 0;

		for (int i = 0; i < flightList.size(); i++) {
			if (flightList.get(i).getSource().equals(from) && flightList.get(i).getDestination().equals(to)) {
				availableFlightCount++;
				availableFlights.add(flightList.get(i));
			}
		}

		if (availableFlightCount > 0) {
			view.printFlightList(availableFlights);

			view.showMessage("\nEnter flight number :");
			int flightId = view.scanInteger();

			view.showMessage("Enter number of passengers :");
			int passengerCount = view.scanInteger();

			for (int i = 1; i <= passengerCount; i++) {
				view.showMessage("\nEnter passenger " + i + " details :\n");

				Passenger passenger = addPassengerDetails();
				data.addPaasengerList(passenger);
				passengerList.add(passenger);

			}

			addBooking(passengerList, flightId);
			view.showMainMenu();
		} else {
			view.showMessage("\nNo Flights Found\n");
			view.showMainMenu();
		}

	}

	private void addBooking(ArrayList<Passenger> passengerList, int flightId) {
		ArrayList<Flight> flightList = data.getFlightList();
		Flight flight = null;
		int flightIndex = 0;
		boolean isFlightAvailable = false;
		Bookings booking = null;

		for (int i = 0; i < flightList.size(); i++) {
			if (flightList.get(i).getFlightId() == flightId) {
				flight = flightList.get(i);
				isFlightAvailable = true;
				break;
			}
		}

		if (isFlightAvailable) {
			booking = new Bookings();
			booking.setPNR(bookingId++);
			booking.setFare(flight.getTravelFare() * passengerList.size());
			booking.setFlight(flight);
			booking.setPassengerList(passengerList);
			booking.setBookedDate(new Date());
			if (flight.getNumberOfSeats() >= passengerList.size()) {
				booking.setStatus("confirm");
			} else {
				booking.setStatus("wl");
			}

			data.addBookingList(booking);
			view.printBooking(booking);
			flight.setNumberOfSeats(flight.getNumberOfSeats() - passengerList.size());
			flightList.set(flightIndex, flight);
			data.setFlightList(flightList);
			view.showMessage("\nSuccessfully Booked\n");
		} else {
			view.showMessage("\nFlight number is incorrect.!\n");
		}
	}

	private Passenger addPassengerDetails()

	{
		Passenger passenger = new Passenger();

		view.showMessage("\nName :");
		passenger.setName(view.scanString());

		view.showMessage("Age :");
		passenger.setAge(view.scanInteger());

		view.showMessage("Gender :");
		passenger.setGender(view.scanString());

		view.showMessage("Passport Number :");
		passenger.setPassportId(view.scanString());

		view.showMessage("Contact Number :");
		passenger.setContactNumber(view.scanString());

		view.showMessage("Emergency contact number :");
		passenger.setEmergencyContact(view.scanString());

		return passenger;
	}

	public void getPNRStatus() {
		ArrayList<Bookings> bookingList = data.getBookingList();
		Bookings booking = null;
		view.showMessage("\nEnter PNR Number");
		int pnr = view.scanInteger();

		for (int i = 0; i < bookingList.size(); i++) {
			if (bookingList.get(i).getPNR() == pnr) {
				booking = bookingList.get(i);
			}
		}

		if (booking != null) {
			view.showMessage("\nYour pnr status : " + booking.getStatus());
		} else {
			view.showMessage("\nNo PNR found.!");
		}
		view.showMainMenu();

	}

	public void bookedTickets() {
		ArrayList<Bookings> bookings = new ArrayList<Bookings>();
		view.printBookingList(bookings);
		view.showMainMenu();
	}

	public void cancelBooking() {
		view.showMessage("\nEnter PNR :");
		int pnr = view.scanInteger();
		ArrayList<Bookings> bookingList = data.getBookingList();
		Bookings booking = null;
		int bookingIndex = -1;

		for (int i = 0; i < bookingList.size(); i++) {
			if (bookingList.get(i).getPNR() == pnr) {
				booking = bookingList.get(i);
				bookingIndex = i;
			}
		}

		if (bookingIndex != -1) {
			booking.setStatus("cancelled");
			bookingList.set(bookingIndex, booking);
			data.setBookingList(bookingList);
			view.showMessage("PNR cancelled.");
		} else {
			view.showMessage("\nPNR not found");
		}

		view.showMainMenu();

	}

	public void searchPassenger() {
		ArrayList<Bookings> bookingList = data.getBookingList();
		ArrayList<Passenger> passengerList = new ArrayList<Passenger>();

		view.showMessage("\nEnter passenger name :");
		String name = view.scanString();

		for (int i = 0; i < bookingList.size(); i++) {
			for (int j = 0; j < bookingList.get(i).getPassengerList().size(); j++) {
				if (bookingList.get(i).getPassengerList().get(j).getName().equals(name)) {
					passengerList.add(bookingList.get(i).getPassengerList().get(j));
					System.out.println(bookingList.get(i).getPassengerList().get(j).getGender());
				}
			}
		}

		if (passengerList.size() < 1) {
			view.showMessage("\nPassenger Name not found.!");
		} else {
			view.printPassengers(passengerList);
		}

		view.showMainMenu();
	}

	public void changeTicketStatus() {
		ArrayList<Bookings> bookingList = data.getBookingList();
		ArrayList<Flight> flightList = data.getFlightList();
		Flight flight = null;
		int flightIndex = 0;
		view.showMessage("\nEnter PNR number :");
		int pnr = view.scanInteger();
		Bookings booking = null;
		int bookingIndex = 0;

		for (int i = 0; i < bookingList.size(); i++) {
			if (bookingList.get(i).getPNR() == pnr) {
				booking = bookingList.get(i);
				bookingIndex = i;
				break;
			}
		}

		view.showBookingStatus();
		String option = view.scanString();

		if (option.equals("1")) {
			for (int i = 0; i < flightList.size(); i++) {
				if (booking.getFlight().getFlightId() == flightList.get(i).getFlightId()) {
					flight = flightList.get(i);
					flightIndex = i;
				}
			}
			if (flight.getNumberOfSeats() >= booking.getPassengerList().size()) {
				booking.setStatus("confirm");
				flight.setNumberOfSeats(flight.getNumberOfSeats() - (booking.getPassengerList().size()));
				flightList.set(flightIndex, flight);
				data.setFlightList(flightList);
				data.setBookingList(bookingList);
				view.showMessage("\nYour PNR is confirmed");
			} else {
				view.showMessage("\nsorry, No seats available.!");
			}
		} else if (option.equals("2")) {
			if (booking.getStatus().equals("confirm")) {
				for (int i = 0; i < flightList.size(); i++) {
					if (booking.getFlight().getFlightId() == flightList.get(i).getFlightId()) {
						flight = flightList.get(i);
						flightIndex = i;
					}
				}
				booking.setStatus("cancelled");
				bookingList.set(bookingIndex, booking);
				data.setBookingList(bookingList);
				flight.setNumberOfSeats(flight.getNumberOfSeats() + (booking.getPassengerList().size()));
				flightList.set(flightIndex, flight);
				data.setFlightList(flightList);
				view.showMessage("\nYour PNR is cancelled, refund will be processed soon.");
			} else {
				booking.setStatus("cancelled");
				bookingList.set(bookingIndex, booking);
				data.setBookingList(bookingList);
				view.showMessage("\nYour PNR is cancelled, refund will be processed soon.");
			}

		} else {
			view.showMessage("\nwrong input.!");
		}
		view.showMainMenu();
	}

	public void readFlights() {
		ArrayList<Flight> flightList = new ArrayList<Flight>();
		try {
			BufferedReader bufferedReader = new BufferedReader(
					new FileReader("E:\\eclipse\\Flight-ticket-booking\\file\\flightRoutes.txt"));
			String flightDetails;
			while ((flightDetails = bufferedReader.readLine()) != null) {
				Flight flight = new Flight();
				String[] flightDetailsArray = flightDetails.split("-");
				flight.setFlightId(Integer.parseInt(flightDetailsArray[0]));
				flight.setFlightName(flightDetailsArray[1]);
				flight.setSource(flightDetailsArray[2]);
				flight.setDestination(flightDetailsArray[3]);
				flight.setNumberOfSeats(Integer.parseInt(flightDetailsArray[4]));
				flight.setDate(flightDetailsArray[5]);
				flight.setArrivalTime(flightDetailsArray[6]);
				flight.setDepaturetime(flightDetailsArray[7]);
				flight.setFlightClass(flightDetailsArray[8]);
				flight.setTravelFare(Integer.parseInt(flightDetailsArray[9]));
				flightList.add(flight);
			}
			bufferedReader.close();
			data.setFlightList(flightList);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void listFlightRoutes() {
		ArrayList<Flight> flightList = data.getFlightList();
		view.printFlightRoutes(flightList);
		view.showMainMenu();
	}

	public void addFlightRoute() {

		Flight flight = new Flight();
		view.showMessage("\nFlight ID :");
		int flightId = view.scanInteger();
		view.showMessage("\nFlight Name :");
		String flightName = view.scanString();
		view.showMessage("\nSource :");
		String source = view.scanString();
		view.showMessage("\ndestination :");
		String destination = view.scanString();
		view.showMessage("\nNumber of Seats :");
		int numberOfSeats = view.scanInteger();
		view.showMessage("\nDate (dd/MM/yyyy) :");
		String date = view.scanString();
		view.showMessage("\nArrival Time (hh:mm:ss) :");
		String depatureTime = view.scanString();
		view.showMessage("\nDepature Time (hh:mm:ss) :");
		String arrivalTime = view.scanString();
		view.showMessage("\nFlight Class :");
		String flightClass = view.scanString();
		view.showMessage("\nTravel Fare :");
		int travelFare = view.scanInteger();
		flight.setFlightId(flightId);
		flight.setFlightName(flightName);
		flight.setSource(source);
		flight.setDestination(destination);
		flight.setNumberOfSeats(numberOfSeats);
		flight.setDate(date);
		flight.setDepaturetime(depatureTime);
		flight.setArrivalTime(arrivalTime);
		flight.setFlightClass(flightClass);
		flight.setTravelFare(travelFare);
		data.addFlight(flight);
		view.showMessage("\nSuccessfully added");
		view.showMainMenu();
	}
}
