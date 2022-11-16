package com.kaja.bankapplication.view;

import java.util.Scanner;
import com.kaja.bankapplication.controller.AdminController;

public class AdminView {
	private MainView mainView;
	private AdminController adminController;
	private Scanner scanner;

	public AdminView(MainView mainView) {
		this.mainView = mainView;
		adminController = new AdminController(this);
		scanner = new Scanner(System.in);

	}

	public void showAdminMenu() {
		System.out.println("- - - - - - - - - - - - -");
		System.out.println("");
		System.out.println("1.Customer details.");
		System.out.println("2.Account Number through mobile number.");
		System.out.println("3.Edit customer details.");
		System.out.println("4.Logout");
		System.out.println("");
		System.out.println("- - - - - - - - - - - - -");

		adminPageOptions();

	}

	public void adminLogin() {
		adminController.adminLogin();
	}

	private void adminPageOptions() {
		System.out.print("Enter Option :");
		String option = scanner.nextLine();
		if (option.equals("1"))
			adminController.showAccountHolderDetails();

		else if (option.equals("2"))
			searchAccount();

		else if (option.equals("3"))
			editCustomerInfo();

		else if (option.equals("4"))
			mainView.showMainMenu();

		else {
			System.out.println("Input incorrect");
			mainView.showMainMenu();
		}
	}

	public void editCustomerInfo() {
		System.out.println("- - - - - - - - - - - - -");
		System.out.println("");
		System.out.println("1.Change name.");
		System.out.println("2.Change dob.");
		System.out.println("3.Change PAN no.");
		System.out.println("4.Change Age.");
		System.out.println("5.Mobile number.");
		System.out.println("6.Admin main page.");
		System.out.println("");
		System.out.println("- - - - - - - - - - - - -");

		System.out.print("Enter option :");
		String option = scanner.nextLine();

		if (option.equals("1"))
			adminController.changeName();

		else if (option.equals("2"))
			adminController.changeDOB();

		else if (option.equals("3"))
			adminController.changePAN();

		else if (option.equals("4"))
			adminController.changeAge();

		else if (option.equals("5"))
			adminController.changeMobileNumber();

		else if (option.equals("6"))
			showAdminMenu();

		else {
			System.out.println("Input incorrect,");
			editCustomerInfo();
		}
	}

	private void searchAccount() {
		System.out.print("Enter mobile number :\n");
		System.out.println(
				"Your result :" + adminController.searchAccountByMobileNumber() + "\n- - - - - - - - - - - - -");
		showAdminMenu();
	}

	public String scanString() {
		return scanner.nextLine();
	}

	public int scanInteger() {
			return Integer.parseInt(scanner.nextLine());	
	}

	public long scanLong() {
		return Long.parseLong(scanner.nextLine());
	}

	public byte scanByte() {
		return Byte.parseByte(scanner.nextLine());
	}

	public void showMessage(String alert) {
		System.out.println(alert);

	}

}
