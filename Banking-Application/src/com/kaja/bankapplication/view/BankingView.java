package com.kaja.bankapplication.view;

import java.util.Scanner;
import com.kaja.bankapplication.controller.BankingController;

public class BankingView {
	private Scanner scanner = new Scanner(System.in);
	private BankingController bankingController;
	private MainView mainView;

	public BankingView() {
		bankingController = new BankingController(this);
		mainView = new MainView();
	}

	BankingView(MainView mainView) {
		this.mainView = mainView;
		bankingController = new BankingController(this);
	}

	public void showBankingMenu(long id) {

		System.out.println("===========================");
		System.out.println("");

		System.out.println("1.Money Transfer.");
		System.out.println("2.Money Deposit.");
		System.out.println("3.Money Withdrawl.");
		System.out.println("4.Balance Check.");
		System.out.println("5.Change Pin.");
		System.out.println("6.Logout.");

		System.out.println("");
		System.out.println("===========================");

		System.out.print("Enter option :");
		String option = scanner.nextLine();

		if (option.equals("1"))
			bankingController.transferMoney(id);

		else if (option.equals("2"))
			bankingController.depositMoney(id);

		else if (option.equals("3"))
			bankingController.withdrawMoney(id);

		else if (option.equals("4"))
			bankingController.checkBalance(id);

		else if (option.equals("5"))
			bankingController.changePin(id);
		else if (option.equals("6"))
			mainView.showMainMenu();

		else {
			System.out.println("Entered Option is wrong.");
			showBankingMenu(id);
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
