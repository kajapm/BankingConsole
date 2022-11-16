package com.kaja.bankapplication.controller;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import com.kaja.bankapplication.model.AccountHolder;
import com.kaja.bankapplication.repositary.BankAppDatabase;
import com.kaja.bankapplication.view.BankingView;

public class BankingController {
	private BankingView bankingView;
	private ArrayList<Long> accountIdList;
	private BankAppDatabase bankAppDatabase;
	private DatabaseConnection data;
	private HashMap<Long, AccountHolder> accountsList;

	public BankingController(BankingView bankingView) {
		this.bankingView = bankingView;
		bankAppDatabase = BankAppDatabase.getInstance();
		data = DatabaseConnection.getInstance();
		accountIdList = bankAppDatabase.getAccountIdList();
		accountsList = bankAppDatabase.getAccountsList();
	}

	public void transferMoney(long id) {
		bankingView.showMessage("Enter account number to send money :");
		long receiver = bankingView.scanLong();

		if (!accountIdList.contains(receiver)) {
			System.out.println("User not found,");
			bankingView.showBankingMenu(id);
		}

		System.out.println("Enter amount to pay");
		long amount = bankingView.scanLong();

		if (isMoneyEnough(id, amount)) {

			long senderBalance = accountsList.get(id).getBalance() - amount;
			(accountsList.get(id)).setBalance(senderBalance);

			try {
				String query = ("update accounts set balance='" + senderBalance + "' where acc_number=" + id);
				PreparedStatement ps;
				ps = data.connection.prepareStatement(query);
				ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}

			long receiverBalance = accountsList.get(receiver).getBalance() + amount;
			accountsList.get(receiver).setBalance(receiverBalance);

			try {
				String query = ("update accounts set balance='" + receiverBalance + "' where acc_number=" + receiver);
				PreparedStatement ps;
				ps = data.connection.prepareStatement(query);
				ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}

			System.out.println("Money Transfered.");
			bankingView.showBankingMenu(id);
		}

		else {
			System.out.println("Transaction failed.");
			bankingView.showBankingMenu(id);
		}

	}

	public void depositMoney(long id) {
		System.out.println("Account number :" + id);
		System.out.println("Account name :" + (accountsList.get(id)).getName());
		System.out.print("Enter amount to deposit :");
		long amount = accountsList.get(id).getBalance() + bankingView.scanLong();
		accountsList.get(id).setBalance(amount);

		try {
			String query = ("update accounts set accountholdername='" + amount + "' where acc_number=" + id);
			PreparedStatement ps;
			ps = data.connection.prepareStatement(query);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		bankingView.showMessage("Money successfully deposited.");
		bankingView.showBankingMenu(id);

	}

	public void withdrawMoney(long id) {
		bankingView.showMessage("Enter amount to withdraw :");
		long amount = bankingView.scanLong();

		if (!isMoneyEnough(id, amount)) {
			bankingView.showMessage("Withdraw failed.");
			bankingView.showBankingMenu(id);
		}

		amount = accountsList.get(id).getBalance() - amount;
		accountsList.get(id).setBalance(amount);
		try {
			String query = ("update accounts set balance='" + amount + "' where acc_number=" + id);
			PreparedStatement ps;
			ps = data.connection.prepareStatement(query);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		bankingView.showMessage("Amount Withdrawl successfully");
		bankingView.showBankingMenu(id);

	}

	private boolean isMoneyEnough(long id, long amount) {
		if (accountsList.get(id).getAccountType().equals("savings")) {
			if (accountsList.get(id).getBalance() < (amount + 500)) {
				bankingView.showMessage("Insufficient balance,minimum balance must be 500.");
				return false;
			}
		}

		else if (accountsList.get(id).getAccountType().equals("salary")
				|| accountsList.get(id).getAccountType().equals("student")) {
			if (accountsList.get(id).getBalance() < (amount)) {
				bankingView.showMessage("Insufficient balance.");
				return false;
			}
		}

		return true;
	}

	public void checkBalance(long id) {
		bankingView.showMessage("Available balance is :" + (accountsList.get(id).getBalance()));
		bankingView.showBankingMenu(id);

	}

	public void changePin(long id) {
		System.out.print("Enter old pin :");
		if (accountsList.get(id).getPin() != bankingView.scanInteger()) {
			System.out.println("Entered wrong pin");
			bankingView.showBankingMenu(id);
		}

		else {
			int pin = createPin();
			(accountsList).get(id).setPin(pin);
		}
		System.out.println("Pin successfully changed");
		bankingView.showBankingMenu(id);

	}

	private int createPin() {
		bankingView.showMessage("Enter new 4-digit pin :");
		int pin = bankingView.scanInteger();
		boolean allowPin = true;
		if (pin < 1000 || pin > 9999) {
			bankingView.showMessage("Your pin must be 4 digit,re-enter your pin :");
			allowPin = false;
		}
		if (allowPin) {
			bankingView.showMessage("Re-Enter your pin :");
			if (pin != bankingView.scanInteger()) {
				bankingView.showMessage("Pin not matched,");
				createPin();
			}
		} else {
			createPin();
		}
		return pin;
	}

}
