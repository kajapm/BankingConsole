package com.kaja.bankapplication.controller;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import com.kaja.bankapplication.model.AccountHolder;
import com.kaja.bankapplication.repositary.BankAppDatabase;
import com.kaja.bankapplication.view.AdminView;

public class AdminController {
	private AdminView adminView;
	private ArrayList<Long> accountsList;
	private BankAppDatabase bankAppDatabase;
	private DatabaseConnection data;
	private HashMap<Long, AccountHolder> accounts;

	public AdminController(AdminView adminView) {
		this.adminView = adminView;
		bankAppDatabase = BankAppDatabase.getInstance();
		accountsList = bankAppDatabase.getAccountIdList();
		accounts = bankAppDatabase.getAccountsList();
		data = DatabaseConnection.getInstance();
	}

	public void adminLogin() {
		adminView.showMessage("Enter admin id");
		String adminId = adminView.scanString();
		adminView.showMessage("Enter admin password");
		String adminPassword = adminView.scanString();

		if (!adminId.equals("admin")) {
			System.out.println("ID and Password not matched");
			adminView.showAdminMenu();
		}
		if (!adminPassword.equals("admin123")) {
			System.out.println("ID and Password not matched");
			adminView.showAdminMenu();
		}
		adminView.showAdminMenu();
	}

	public String searchAccountByMobileNumber() {
		String mobileNumber = adminView.scanString();
		for (HashMap.Entry<Long, AccountHolder> entry : accounts.entrySet()) {
			if ((entry.getValue()).getMobileNumber().equals(mobileNumber)) {
				return String.valueOf(entry.getKey());
			}
		}
		return "Not Found";
	}

	public void changeName() {
		System.out.print("Enter account no :");
		Long id = adminView.scanLong();

		if (!accountsList.contains(id)) {
			adminView.showMessage("User not found");
			adminView.editCustomerInfo();
		}
		System.out.print("Enter new name :");
		String name = adminView.scanString();
		accounts.get(id).setName(name);

		try {
			String query = ("update accounts set accountholdername='" + name + "' where acc_number=" + id);
			PreparedStatement ps;
			ps = data.connection.prepareStatement(query);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		adminView.showMessage("Name successfully changed");
		adminView.editCustomerInfo();
	}

	public void changeDOB() {
		adminView.showMessage("Enter account no :");
		Long id = adminView.scanLong();

		if (!accountsList.contains(id)) {
			adminView.showMessage("User not found");
			adminView.editCustomerInfo();
		}
		adminView.showMessage("Enter new DOB :");
		String dob = adminView.scanString();
		accounts.get(id).setDateOfBirth(dob);

		try {
			String query = ("update accounts set dob='" + dob + "' where acc_number=" + id);
			PreparedStatement ps;
			ps = data.connection.prepareStatement(query);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		adminView.showMessage("DOB successfully changed");
		adminView.editCustomerInfo();
	}

	public void changePAN() {
		adminView.showMessage("Enter account no :");
		Long id = adminView.scanLong();

		if (!accountsList.contains(id)) {
			System.out.println("User not found");
			adminView.editCustomerInfo();
		}
		System.out.print("Enter new PAN :");
		String panNumber = adminView.scanString();
		accounts.get(id).setPanNumber(panNumber);

		try {
			String query = ("update accounts set pan='" + panNumber + "' where acc_number=" + id);
			PreparedStatement ps;
			ps = data.connection.prepareStatement(query);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		adminView.showMessage("PAN no successfully changed");
		adminView.editCustomerInfo();
	}

	public void changeAge() {
		try {
			System.out.print("Enter account no :");
			Long id = adminView.scanLong();

			if (!accountsList.contains(id)) {
				System.out.println("User not found");
				adminView.editCustomerInfo();
			}
			System.out.print("Enter Age :");
			byte age = adminView.scanByte();
			accounts.get(id).setAge(age);

			try {
				String query = ("update accounts set age='" + age + "' where acc_number=" + id);
				PreparedStatement ps;
				ps = data.connection.prepareStatement(query);
				ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}

			adminView.showMessage("Age successfully changed");
			adminView.editCustomerInfo();
		}

		catch (NumberFormatException e) {
			adminView.showMessage("Input incorrect");
			adminView.editCustomerInfo();
		}
	}

	public void changeMobileNumber() {
		adminView.showMessage("Enter account no :");
		Long id = adminView.scanLong();

		if (!accountsList.contains(id)) {
			adminView.showMessage("User not found");
			adminView.editCustomerInfo();
		}
		adminView.showMessage("Enter new Mobile number :");
		String mobileNumber = adminView.scanString();
		(accounts.get(id)).setMobileNumber(mobileNumber);

		try {
			String query = ("update accounts set mobile_number='" + mobileNumber + "' where acc_number=" + id);
			PreparedStatement ps;
			ps = data.connection.prepareStatement(query);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		adminView.showMessage("Mobile number successfully changed");
		adminView.editCustomerInfo();
	}

	public void showAccountHolderDetails() {
		try {
			adminView.showMessage("Enter Account Number :");
			long id = adminView.scanLong();
			if (!accountsList.contains(id)) {
				System.out.println("User not found,");
				adminView.showAdminMenu();
			}
			System.out.println("- - - - - - - - - - - - -");
			System.out.println("");
			System.out.println("Account holder name :" + accounts.get(id).getName());
			System.out.println("Account number :" + id);
			System.out.println("Date-Of-Birth :" + accounts.get(id).getDateOfbirth());
			System.out.println("Age :" + accounts.get(id).getAge());
			System.out.println("Mobile Number :" + accounts.get(id).getMobileNumber());
			System.out.println("Pan no :" + accounts.get(id).getPanNumber());
			System.out.println("Account Type :" + accounts.get(id).getAccountType());
			System.out.println("Account Balance :" + accounts.get(id).getBalance());
			System.out.println("Account Balance :" + accounts.get(id).getBranch());
			System.out.println("");
			System.out.println("- - - - - - - - - - - - -");

			adminView.showAdminMenu();

		}

		catch (NumberFormatException e) {
			System.out.println("Incorrect Input.");
			adminView.showAdminMenu();
		}
	}

}
