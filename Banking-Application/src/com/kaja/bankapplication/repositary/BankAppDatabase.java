package com.kaja.bankapplication.repositary;

import java.util.ArrayList;
import java.util.HashMap;
import com.kaja.bankapplication.model.AccountHolder;

public class BankAppDatabase {
	private ArrayList<Long> accountIdList;
	private HashMap<Long, AccountHolder> accountsList;
	public static BankAppDatabase database;

	private BankAppDatabase() {
		accountIdList = new ArrayList<Long>();
		accountsList = new HashMap<Long, AccountHolder>();
	}

	public static BankAppDatabase getInstance() {
		if (database == null) {
			database = new BankAppDatabase();
		}
		return database;
	}

	public ArrayList<Long> getAccountIdList() {
		return database.accountIdList;
	}

	public void setAccountIdList(ArrayList<Long> accountsList) {
		database.accountIdList = accountsList;
	}

	public HashMap<Long, AccountHolder> getAccountsList() {
		return database.accountsList;
	}

	public void setAccountsList(HashMap<Long, AccountHolder> accounts) {
		database.accountsList = accounts;
	}
}
