package com.kaja.bankapplication.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import com.kaja.bankapplication.model.AccountHolder;
import com.kaja.bankapplication.repositary.BankAppDatabase;

public class DatabaseConnection {
	Connection connection;
	private BankAppDatabase database;
	private Statement statement;
	private ResultSet resultSet;
	private ArrayList<Long> accountIdList;
	private HashMap<Long, AccountHolder> accountsList;
	static DatabaseConnection databaseConnection;

	private DatabaseConnection() {
		try {
			accountIdList = new ArrayList<Long>();
			accountsList = new HashMap<Long, AccountHolder>();
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/banking", "root", "wasd");
			statement = connection.createStatement();
			database = BankAppDatabase.getInstance();
		} catch (SQLException e) {
			System.out.println(e.toString());
		}
	}

	public static DatabaseConnection getInstance() {
		if (databaseConnection == null) {
			databaseConnection = new DatabaseConnection();
		}
		return databaseConnection;
	}

	public void loadData() {
		try {
			resultSet = statement.executeQuery("select * from accountlist");
			while (resultSet.next()) {
				long accountNumber = Long.parseLong(resultSet.getString(2));
				accountIdList.add(accountNumber);
			}

			resultSet = statement.executeQuery("select * from accounts");
			while (resultSet.next()) {
				Long accountNumber = Long.parseLong(resultSet.getString(9));
				accountsList.put(accountNumber, new AccountHolder());
				AccountHolder user = accountsList.get(accountNumber);

				user.setName(resultSet.getString(1));
				user.setPin(resultSet.getInt(2));
				user.setBalance(resultSet.getLong(3));
				user.setPanNumber(resultSet.getString(4));
				user.setAccountType(resultSet.getString(5));
				user.setDateOfBirth(resultSet.getString(6));
				user.setAge(resultSet.getByte(7));
				user.setBranch(resultSet.getString(8));
				user.setAccountNumber(resultSet.getLong(9));
				user.setMobileNumber(resultSet.getString(10));
			}
			database.setAccountsList(accountsList);
			database.setAccountIdList(accountIdList);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
