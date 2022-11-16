package com.kaja.bankapplication.view;

import java.util.Scanner;

public class MainView {
	private AdminView adminView;
	private UserView userView;
	private Scanner scanner;

	MainView() {
		adminView = new AdminView(this);
		userView = new UserView(this);
		scanner = new Scanner(System.in);
	}

	public void showMainMenu() {
		System.out.println("=-=-=-=-=-=-=-=-=-=-=-=");
		System.out.println("\tZ Bank ");
		System.out.println("-=-=-=-=-=-=-=-=-=-=-=-");
		System.out.println("");

		System.out.println("1.User Login");
		System.out.println("2.Admin login");
		System.out.println("3.Exit");
		System.out.println("");
		System.out.println("========================");

		String option = scanner.nextLine();

		if (option.equals("1")) {

			userView.userLogin();
		}

		else if (option.equals("2")) {
			adminView.adminLogin();
		} else if (option.equals("3")) {
			System.out.println("\t===========");
			System.out.println("\tThank you.!");
			System.out.println("\t===========");
			return;
		} else {
			System.out.println("Entered option is incorrect.");
			showMainMenu();
		}
	}
}
