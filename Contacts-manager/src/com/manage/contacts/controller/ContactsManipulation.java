package com.kaja.contactsmanager.controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import com.kaja.contactsmanager.model.DataConnection;
import com.kaja.contactsmanager.view.MainView;

public class ContactsManipulation {
	private Scanner scanner;
	private MainView mainView;
	private ResultSet resultSet;
	private DataConnection dataConnection;

	public ContactsManipulation(MainView mainView) {
		this.mainView = mainView;
		scanner = new Scanner(System.in);
		dataConnection = DataConnection.getInstance();
	}

	public void viewContacts() {

		try {
			System.out.println("Name\tNumber");
			System.out.println("");
			resultSet = dataConnection.statement.executeQuery("select * from contactslist");

			while (resultSet.next()) {
				System.out.println(resultSet.getString(2) + "\t" + resultSet.getString(3));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mainView.mainMenu();
	}

	public void createContact() {
		System.out.print("Enter name :");
		String name = scanner.nextLine();

		System.out.print("Enter number :");
		String number = scanner.nextLine();

		System.out.println("Contact Type");
		System.out.println("1.Home");
		System.out.println("2.work");
		System.out.println("3.personal");
		System.out.println("4.colleague");
		System.out.println("");
		System.out.print("Enter your option :");
		System.out.println("");

		String option = scanner.nextLine();
		String type = "";
		if (option.equals("1")) {
			type = "home";
		}

		else if (option.equals("2")) {
			type = "work";
		}

		else if (option.equals("3")) {
			type = "personal";
		}

		else if (option.equals("4")) {
			type = "colleague";
		}

		else {
			System.out.println("Input wrong");
			createContact();
		}

		try {
			String query = ("insert into contactslist (contactname,contactnumber,contacttype) values ('" + name + "','"
					+ number + "','" + type + "')");
			PreparedStatement ps = dataConnection.connection.prepareStatement(query);
			ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.toString());
			;
		}
		System.out.println("contact saved");
		mainView.mainMenu();
	}

	public void searchContact() {
		System.out.println("Enter contact name");
		String name = scanner.nextLine();
		int count = 0;
		try {
			resultSet = dataConnection.statement.executeQuery("select * from contactslist");

			System.out.println("");
			System.out.println("Name\tNumber");
			System.out.println("");

			while (resultSet.next()) {
				if (resultSet.getString(2).contains(name)) {
					System.out.println(resultSet.getString(2) + "\t" + resultSet.getString(3));
					count++;
				}
			}
			if (count == 0) {
				System.out.println("No contact found !");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		mainView.mainMenu();
	}

	public void viewByType() {
		System.out.println("Select your type :");

		System.out.println("Contact Type");
		System.out.println("1.Home");
		System.out.println("2.work");
		System.out.println("3.personal");
		System.out.println("4.colleague");
		System.out.println("");
		System.out.print("Enter your option :");
		System.out.println("");

		String option = scanner.nextLine();
		String type = "";
		if (option.equals("1")) {
			type = "home";
		}

		else if (option.equals("2")) {
			type = "work";
		}

		else if (option.equals("3")) {
			type = "personal";
		}

		else if (option.equals("4")) {
			type = "colleague";
		}

		else {
			System.out.println("Input wrong");
			viewByType();
		}

		try {
			resultSet = dataConnection.statement.executeQuery("select * from contactslist");

			System.out.println("Name\tNumber");
			System.out.println("");

			while (resultSet.next()) {
				if (resultSet.getString(4).equals(type)) {
					System.out.println(resultSet.getString(2) + "\t" + resultSet.getString(3));
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		mainView.mainMenu();
	}

	public void deleteContact() {
		System.out.println("1.View all contacts");
		System.out.println("2.search contact");
		System.out.println("");
		System.out.print("Enter your option :");
		System.out.println("");

		String option = scanner.nextLine();
		if (option.equals("1")) {
			try {
				System.out.println("ID\tName\tNumber");
				System.out.println("");
				resultSet = dataConnection.statement.executeQuery("select * from contactslist");

				while (resultSet.next()) {
					System.out.println(
							resultSet.getString(1) + "\t" + resultSet.getString(2) + "\t" + resultSet.getString(3));
				}

				System.out.println("");
				System.out.print("Enter id to delete :");

				int id = Integer.parseInt(scanner.nextLine());

				String query = ("delete from contactslist where id=" + id);
				PreparedStatement ps = dataConnection.connection.prepareStatement(query);
				ps.executeUpdate();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println(e.toString());
				System.out.println("Incorrect input.");
				mainView.mainMenu();
			}

			System.out.println("Contact deleted");
			mainView.mainMenu();
		}

		else if (option.equals("2")) {
			System.out.println("Enter contact name");
			String name = scanner.nextLine();
			try {
				resultSet = dataConnection.statement.executeQuery("select * from contactslist");

				System.out.println("ID\tName\tNumber");
				System.out.println("");

				while (resultSet.next()) {
					if (resultSet.getString(2).contains(name)) {
						System.out.println(
								resultSet.getString(1) + "\t" + resultSet.getString(2) + "\t" + resultSet.getString(3));
					}

					System.out.print("Enter id to delete :");

					int id = Integer.parseInt(scanner.nextLine());

					String query = ("delete from contactslist where id=" + id);
					PreparedStatement ps = dataConnection.connection.prepareStatement(query);
					ps.executeUpdate();
				}

			} catch (SQLException e) {
				System.out.println(e.toString());
				System.out.println("Incorrect input.");
				mainView.mainMenu();
			}

			System.out.println("Contact deleted");
			mainView.mainMenu();
		}
	}
}