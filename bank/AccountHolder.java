package com.bank;

public class AccountHolder
{
	private String name;
	private int pin;
	private long balance;
	private String panNumber; 
	private String accountType;
	private String dateOfBirth;
	private byte age;
	private String branch;
	private int accountNumber;
	private String mobileNumber;
	
	public void setPin(int newPin)
	{
		pin=newPin;
	}
	
	public void setMobileNumber(String newMobileNumber)
	{
		mobileNumber=newMobileNumber;
	}
	
	public String getMobileNumber()
	{
		return mobileNumber;
	}
	
	public void setName(String newName)
	{
		name=newName;
	}
	
	public void setPanNumber(String newPanNumber)
	{
		panNumber=newPanNumber;
	}
	
	public void setAccountType(String newAccountType)
	{
		accountType=newAccountType;
	}
	
	public void setDateOfBirth(String newDateOfBirth)
	{
		dateOfBirth=newDateOfBirth;
	}
	
	public void setAge(byte newAge)
	{
		age=newAge;
	}
	
	public void setBranch(String newBranch)
	{
		branch=newBranch;
	}
	
	public void setBalance(long newBalance)
	{
		balance=newBalance;
	}
	
	public void setAccountNumber(int newAccountNumber)
	{
		accountNumber=newAccountNumber;
	}
	
	public int getAccountNumber()
	{
		return accountNumber;
	}
	
	public int getPin()
	{
		return pin;
	}
	
	public String getPanNumber()
	{
		return panNumber;
	}
	
	public String getName()
	{
		return name;
	}
	
	public String getAccountType()
	{
		return accountType;
	}
	
	public String getDateOfbirth()
	{
		return dateOfBirth;
	}
	
	public byte getAge()
	{
		return age;
	}
	
	public String getBranch()
	{
		return branch;
	}
	
	public long getBalance()
	{
		return balance;
	}
}
