package com.bank;

public class BankApp 
{
	public static void main(String args[])
	{
		Banking banking=new Banking();
		banking.loadDefault();
		banking.loginPage();
	}
}