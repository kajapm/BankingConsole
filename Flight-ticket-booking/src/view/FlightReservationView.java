package view;

import java.util.ArrayList;
import java.util.Scanner;
import controller.FlightReservationControl;
import model.Bookings;
import model.Flight;
import model.Passenger;

public class FlightReservationView {
	private String option;
	private Scanner scanner = new Scanner(System.in);
	private FlightReservationControl flightReservationControl;

	public FlightReservationView() {
		flightReservationControl = new FlightReservationControl(this);
	}

	public void showWelcomeMessage() {
		System.out.println("\twelcome to flight reservation application\n");
		flightReservationControl.readFlights();
	}

	public void showMainMenu() {
		System.out.println("\n1.Book ticket\n" + "2.Get PNR status\n" + "3.Booked tickets\r\n"
				+ "4.Cancel booked ticket\r\n" + "5.Search passenger\r\n" + "6.Change ticket status of passenger\r\n"
				+ "7.List flight routes\r\n" + "8.Add flight route\r\n" + "9.Exit");
		optionForMainMenu();
	}

	private void optionForMainMenu() {
		option = scanner.nextLine();

		switch (option) {
		case ("1"):
			flightReservationControl.bookTicket();
			break;
		case ("2"):
			flightReservationControl.getPNRStatus();
			break;
		case ("3"):
			flightReservationControl.bookedTickets();
			break;
		case ("4"):
			flightReservationControl.cancelBooking();
			break;
		case ("5"):
			flightReservationControl.searchPassenger();
			break;
		case ("6"):
			flightReservationControl.changeTicketStatus();
			break;
		case ("7"):
			flightReservationControl.listFlightRoutes();
			break;
		case ("8"):
			flightReservationControl.addFlightRoute();
			break;
		case ("9"):
			System.out.println("Thank you..!");
			break;
		default:
			System.out.println("Input wrong..!");
			showMainMenu();
		}
	}

	public void printFlightList(ArrayList<Flight> flightList) {
		for (Flight flight : flightList) {
			System.out.println("Flight name : " + flight.getFlightName() + "\nFlight ID : " + flight.getFlightId()
					+ "\nFlight class : " + flight.getFlightClass() + "\nDate : " + flight.getDate()
					+ "\nDepature time : " + flight.getDepatureTime() + "\nArrival time : " + flight.getArrivalTime()
					+ "\nNo-of-Seats :" + flight.getNumberOfSeats());
		}
	}

	public void printBooking(Bookings booking) {
		System.out.println("\nYour Booking details :\n" + "\nPNR :" + booking.getPNR() + "\nTotal Fare :"
				+ booking.getFare() + "\nFlight Number :" + booking.getFlight().getFlightId() + "\nSeats :"
				+ booking.getPassengerList().size() + "\nDate :" + booking.getBookedDate() + "\nStatus :"
				+ booking.getStatus() + "\n");
	}

	public void printBookingList(ArrayList<Bookings> bookings) {
		for (int i = 0; i < bookings.size(); i++) {
			Bookings eachBooking = bookings.get(i);
			System.out.println("\n PNR :" + eachBooking.getPNR() + " TrainId :" + eachBooking.getFlight().getFlightId()
					+ " Date" + eachBooking.getBookedDate() + " Status :" + eachBooking.getStatus());
		}
	}

	public void printPassengers(ArrayList<Passenger> passengerList) {
		for (int i = 0; i < passengerList.size(); i++) {
			System.out.println("\nPassenger name : " + passengerList.get(i).getName() + "\nPassenger Age : "
					+ passengerList.get(i).getAge() + "\nPassenger Gender : " + passengerList.get(i).getGender()
					+ "\nPassenger Contact Number : " + passengerList.get(i).getContactNumber() + "\n");
		}
	}

	public void showBookingStatus() {
		System.out.println("\n1.Confirm ticket\n2.Cancel ticket\n\nEnter your option :");
	}

	public String scanString() {
		return scanner.nextLine();
	}

	public int scanInteger() {
		try {
			return Integer.parseInt(scanner.nextLine());
		} catch (NumberFormatException e) {
			System.out.println("Input wrong.!");
			showMainMenu();
			return 0;
		}
	}

	public void showMessage(String alert) {
		System.out.println(alert);
	}

	public void printFlightRoutes(ArrayList<Flight> flightList) {
		for (int i = 0; i < flightList.size(); i++) {
			System.out.println("Flight id : " + flightList.get(i).getFlightId());
			System.out.println("Flight name : " + flightList.get(i).getFlightName());
			System.out.println("From : " + flightList.get(i).getSource());
			System.out.println("To : " + flightList.get(i).getDestination() + "\n");
		}
	}
}
