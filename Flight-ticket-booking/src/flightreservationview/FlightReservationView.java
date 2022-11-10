package flightreservationview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import flightreservationcontrol.FlightReservationControl;
import flightreservationmodel.Bookings;
import flightreservationmodel.Flight;

public class FlightReservationView {
	private String option;
	private Scanner scanner = new Scanner(System.in);
	private FlightReservationControl flightReservationControl;

	public FlightReservationView() {
		flightReservationControl = new FlightReservationControl(this);
	}

	public void mainMenu() {
		System.out.println("""
					welcome to flight reservation application

				1.Book ticket
				2.Get PNR status
				3.Booked tickets
				4.Cancel booked ticket
				5.Search passenger
				6.Change ticket status of passenger
				7.List flight routes
				8.Add flight route
				9.Exit
				""");
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
			mainMenu();
		}
	}

	public void printFlightList(HashMap<Integer,Flight> flightList) {
		for (Map.Entry<Integer,Flight> entry:flightList.entrySet()) {
			Flight flight = entry.getValue();

			System.out.println("Flight name : " + flight.getFlightName());
			System.out.println("Flight ID : " + flight.getFlightId());
			System.out.println("Flight class : " + flight.getClass());
			System.out.println("Date : " + flight.getDate());
			System.out.println("Depature time : " + flight.getDepatureTime());
			System.out.println("Arrival time : " + flight.getArrivalTime());
		}
	}

	public String scanString() {
		return scanner.nextLine();
	}

	public void print(String alert) {
		System.out.print(alert);
	}

	public void println(String alert) {
		System.out.println(alert);
	}

	public void printBooking(Bookings booking) {
		System.out.println("\nYour Booking details :\n");
		System.out.println("PNR :"+booking.getPNR());
		System.out.println("Total Fare :"+booking.getFare());
		System.out.println("Flight Number :"+booking.getFlight().getFlightId());
		System.out.println("Seats :"+booking.getPassengerList().size());
		System.out.println("Date :"+booking.getBookedDate());
		System.out.println("Status :"+booking.getStatus());
		
	}

	public void printBookingList(ArrayList<Bookings> bookings) {
		
		for(int i=0;i<bookings.size();i++)
		{
			Bookings eachBooking=bookings.get(i);
			System.out.println("\n PNR :"+eachBooking.getPNR()+" TrainId :"+eachBooking.getFlight().getFlightId()+" Date"+eachBooking.getBookedDate()+" Status :"+eachBooking.getStatus());
		}
	}
}
