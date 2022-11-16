package com.kaja.bankapplication.controller;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import com.kaja.bankapplication.model.AccountHolder;
import com.kaja.bankapplication.repositary.BankAppDatabase;
import com.kaja.bankapplication.view.BankingView;
import com.kaja.bankapplication.view.UserView;

public class UserController {
	private HashMap<Long, AccountHolder> accountsList;
	private ArrayList<Long> accountIdList;
	private UserView userView;
	private BankAppDatabase bankAppDatabase;
	private Long currentUser = 1007000001l;
	private BankingView bankingView;

	public UserController(UserView userView) {
		this.userView = userView;
		bankAppDatabase = BankAppDatabase.getInstance();
	}

	public void login() {
		accountIdList = bankAppDatabase.getAccountIdList();
		accountsList = bankAppDatabase.getAccountsList();
		try {
			System.out.print("Enter account number :");
			long id = userView.scanLong();

			System.out.print("Enter pin :");
			int pin = userView.scanInteger();

			if (!accountIdList.contains(id)) {
				System.out.println("Account number not matched");
				userView.userLogin();
			}

			if ((accountsList.get(id).getPin()) != pin) {
				System.out.println("Wrong pin");
				userView.userLogin();
			}
			bankingView = new BankingView();
			bankingView.showBankingMenu(id);
		}

		catch (NumberFormatException e) {
			System.out.println("Input Wrong.");
			userView.userLogin();
		}
	}

	public void create() {

		try {
			accountIdList = bankAppDatabase.getAccountIdList();
			accountsList = bankAppDatabase.getAccountsList();

			currentUser++;
			accountsList.put(currentUser, new AccountHolder());

			userView.showMessage("Enter your name :");
			String name = userView.scanString();
			accountsList.get(currentUser).setName(name);

			userView.showMessage("Enter Age :");
			byte age = userView.scanByte();
			accountsList.get(currentUser).setAge(age);

			userView.showMessage("Enter Date-Of-Birth :");
			String dob = userView.scanString();
			accountsList.get(currentUser).setDateOfBirth(dob);

			userView.showMessage("Enter MobileNumber :");
			String mobileNumber = userView.scanString();
			accountsList.get(currentUser).setMobileNumber(mobileNumber);

			userView.showMessage("Enter PAN number :");
			String panNumber = userView.scanString();
			accountsList.get(currentUser).setPanNumber(panNumber);

			userView.showMessage("Enter your city :");
			String branch = userView.scanString();
			accountsList.get(currentUser).setBranch(branch);

			int pin = createPin();
			accountsList.get(currentUser).setPin(pin);

			String type = "";
			if (accountsList.get(currentUser).getAge() >= 18) {
				type = setAccount();
				accountsList.get(currentUser).setAccountType(type);
			}

			else {
				type = "student";
				accountsList.get(currentUser).setAccountType(type);
			}
			accountIdList.add(currentUser);
			System.out.println("Account created.!");
			System.out.println("Your account number is " + currentUser);

			DatabaseConnection databaseConnection = DatabaseConnection.getInstance();
			String query = ("insert into accountlist(accountnumber) values (" + currentUser + ")");
			PreparedStatement ps = databaseConnection.connection.prepareStatement(query);
			ps.executeUpdate();

			query = ("insert into accounts values ('" + name + "'," + pin + "," + 0 + ",'" + panNumber + "','" + type
					+ "','" + dob + "'," + age + ",'" + branch + "'," + currentUser + ",'" + mobileNumber + "')");
			ps = databaseConnection.connection.prepareStatement(query);
			ps.executeUpdate();

		} catch (SQLException | NumberFormatException e) {
			e.printStackTrace();
			userView.showMessage("\nInput Wrong.\n");
		}
	}

	private int createPin() {

		userView.showMessage("Enter new 4-digit pin :");
		int pin = userView.scanInteger();
		boolean allowPin = true;
		if (pin < 1000 || pin > 9999) {
			userView.showMessage("Your pin must be 4 digit,re-enter your pin :");
			allowPin = false;
		}
		if (allowPin) {
			userView.showMessage("Re-Enter your pin :");
			if (pin != userView.scanInteger()) {
				userView.showMessage("Pin not matched,");
				createPin();
			}
		} else {
			createPin();
		}
		return pin;
	}

	private String setAccount() {
		System.out.println("1.Savings Account (Minimum balance must be 500)");
		System.out.println("2.Salary Account (Minimum balance is 0)");

		String option = userView.scanString();

		if (option.equals("1")) {
			return "savings";
		} else if (option.equals("2")) {
			return "salary";
		} else {
			System.out.println("Entered option is wrong");
			return setAccount();
		}
	}

}
