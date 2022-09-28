package com.bank;

import java.util.Scanner;

class Banking
{
	Scanner scan=new Scanner(System.in);
	Accounts accountsObj=new Accounts();
	
	public void loadDefault()
	{
		accountsObj.accountsList=accountsObj.getList();
		accountsObj.accounts=accountsObj.getMap();
	}
	
	public void loginPage()
	{
		System.out.println("=-=-=-=-=-=-=-=-=-=-=-=");
		System.out.println("\tZ Bank ");
		System.out.println("-=-=-=-=-=-=-=-=-=-=-=-");
		System.out.println("");
		
		System.out.println("1.User Login");
		System.out.println("2.Admin login");
		System.out.println("3.Exit");
		System.out.println("");
		System.out.println("========================");
	
		String option=scan.nextLine();
		
		if(option.equals("1"))
		{
			System.out.println("- - - - - - - - - - - - -");
			System.out.println("");
			System.out.println("1.Login.");
			System.out.println("2.Create account.");
			System.out.println("3.Main Page");
			System.out.println(""); 
			System.out.println("- - - - - - - - - - - - -");
			
			
			userLogin();
		}
			
		else if(option.equals("2"))
		{
			adminLogin();
		}
		else if(option.equals("3"))
		{
			System.out.println("\t===========");
			System.out.println("\tThank you.!");
			System.out.println("\t===========");
		}
		else
		{
			System.out.println("Entered option is incorrect.");
			loginPage();
		}
	}
	
	public void userLogin()
	{
		String option=scan.nextLine();
		
		if(option.equals("1"))
		{
			login();
		}
		
		else if(option.equals("2"))
		{
			accountsObj.create();
			accountsObj.accountsList=accountsObj.getList();
			accountsObj.accounts=accountsObj.getMap();
			loginPage();
		}
		
		else if(option.equals("3"))
		{
			loginPage();
		}
	}
	
	public void login()
	{
		
		System.out.println(accountsObj.accountsList);
		try {
		System.out.print("Enter account number :");
		long id=Long.parseLong(scan.nextLine());
		
		System.out.print("Enter pin :");
		int pin=Integer.parseInt(scan.nextLine());
		
		if(!accountsObj.accountsList.contains(id))
		{
			System.out.println("Account number not matched");
			loginPage();
		}
		
		if((accountsObj.accounts.get(id).getPin())!=pin) 
		{
			System.out.println("Wrong pin");
			loginPage();
		}
		bankingPage(id);
		}
		
		catch(Exception e)
		{
			System.out.println("Input Wrong.");
			loginPage();
		}
		
	}
	
	public void bankingPage(long id)
	{
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
		option(id);	
	}
	
	public void option(long id)
	{
		System.out.print("Enter option :");
		String option=scan.nextLine();
		
		if(option.equals("1"))
				moneyTransfer(id);
		
		else if(option.equals("2"))
			moneyDeposit(id);
		
		else if(option.equals("3"))
			moneyWithdrawl(id);
		
		else if(option.equals("4"))
			balanceCheck(id);
		
		else if(option.equals("5"))
			changePin(id);
		else if(option.equals("6"))
			loginPage();
	
		else
		{
			System.out.println("Entered Option is wrong.");
			bankingPage(id);
		}
		
	}
	
	public void moneyTransfer(long id)
	{
		System.out.print("Enter account number to send money :");
		long receiver=Long.parseLong(scan.nextLine());
		
		if(!accountsObj.accountsList.contains(receiver))
		{
			System.out.println("User not found,");
			bankingPage(id);
		}
		
		System.out.println("Enter amount to pay");
		long amount=Long.parseLong(scan.nextLine());
		
		
		if(isMoneyEnough(id,amount))
		{
		
			(accountsObj.accounts.get(id)).setBalance((accountsObj.accounts.get(id)).getBalance()-amount);
			(accountsObj.accounts.get(receiver)).setBalance((accountsObj.accounts.get(receiver)).getBalance()+amount);
			System.out.println("Money Transfered.");
			bankingPage(id);
		}
		
		else
		{
			System.out.println("Transaction failed.");
			bankingPage(id);
		}
			
	}
	
	private void moneyDeposit(long id) 
	{
		System.out.println("Account number :"+id);
		System.out.println("Account name :"+(accountsObj.accounts.get(id)).getName());
		System.out.print("Enter amount to deposit :");
		long amount=Long.parseLong(scan.nextLine());
		(accountsObj.accounts.get(id)).setBalance(accountsObj.accounts.get(id).getBalance()+amount);
		System.out.println("Money successfully deposited.");
		bankingPage(id);
	}
	
	private void moneyWithdrawl(long id) 
	{
		System.out.print("Enter amount to withdraw :");
		long amount=Long.parseLong(scan.nextLine());
		
		if(!isMoneyEnough(id,amount))
		{
			System.out.println("Withdraw failed.");
			bankingPage(id);
		}
	}
	
	public boolean isMoneyEnough(long id,long amount)
	{
		if((accountsObj.accounts.get(id)).getAccountType().equals("savings"))
		{
			if((accountsObj.accounts.get(id)).getBalance()<(amount+500))
			{
				System.out.println("Insufficient balance,minimum balance must be 500.");
				return false;
			}
		}
		
		else if((accountsObj.accounts.get(id)).getAccountType().equals("salary") ||
				(accountsObj.accounts.get(id)).getAccountType().equals("student"))
		{
			if((accountsObj.accounts.get(id)).getBalance()<(amount))
			{
				System.out.println("Insufficient balance.");
				return false;
			}
		}
		
		return true;
	}
	
	private void balanceCheck(long id) 
	{
		System.out.println("Available balance is :"+(accountsObj.accounts.get(id).getBalance()));
		bankingPage(id);
	}
	
	private void changePin(long id) 
	{
		System.out.print("Enter old pin :");
		if((accountsObj.accounts.get(id)).getPin()!=Integer.parseInt(scan.nextLine()))
		{
			System.out.println("Entered wrong pin");
			bankingPage(id);
		}
		
		else
		{
			int pin=accountsObj.createPin();
			((accountsObj.accounts).get(id)).setPin(pin);
		}
		System.out.println("Pin successfully changed");
		bankingPage(id);
	}
	
	
	
	
	
	
	public void adminLogin()
	{
		accountsObj.accountsList=accountsObj.getList();
		accountsObj.accounts=accountsObj.getMap();
		System.out.println("Enter admin id");
		String adminId=scan.nextLine();
		System.out.println("Enter admin password");
		String adminPassword=scan.nextLine();
		
		if(!adminId.equals("admin"))
		{
			System.out.println("ID and Password not matched");
			loginPage();
		}
		if(!adminPassword.equals("admin123"))
		{
			System.out.println("ID and Password not matched");
			loginPage();
		}
		
		Admin admin=new Admin();
		admin.adminPage();
	}	
}
	
