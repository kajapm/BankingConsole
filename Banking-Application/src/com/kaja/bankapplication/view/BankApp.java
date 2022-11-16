package com.kaja.bankapplication.view;

import com.kaja.bankapplication.controller.DatabaseConnection;

public class BankApp {
	public static void main(String args[]) {
		DatabaseConnection databaseConnection = DatabaseConnection.getInstance();
		databaseConnection.loadData();
		MainView mainView = new MainView();
		mainView.showMainMenu();
	}
}