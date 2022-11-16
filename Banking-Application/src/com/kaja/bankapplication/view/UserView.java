package com.kaja.bankapplication.view;

import java.util.Scanner;
import com.kaja.bankapplication.controller.UserController;

public class UserView {
	private MainView mainView;
	private UserController userController;
	private Scanner scanner;

	public UserView(MainView mainView) {
		this.mainView = mainView;
		userController = new UserController(this);
		scanner = new Scanner(System.in);
	}

	public void userLogin() {
		System.out.println("- - - - - - - - - - - - -");
		System.out.println("");
		System.out.println("1.Login.");
		System.out.println("2.Create account.");
		System.out.println("3.Main Page");
		System.out.println("");
		System.out.println("- - - - - - - - - - - - -");

		String option = scanner.nextLine();

		if (option.equals("1")) {
			userController.login();
		}

		else if (option.equals("2")) {
			userController.create();
			mainView.showMainMenu();
		}

		else if (option.equals("3")) {
			mainView.showMainMenu();
		}
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
