package com.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Accounts
{
	long accountNumberGenerator=1007000000l;
	Scanner scan=new Scanner(System.in);
	ArrayList<Long> accountsList=new ArrayList<Long>();
	HashMap<Long,AccountHolder> accounts=new HashMap<Long,AccountHolder>();
	long currentUser=accountNumberGenerator++;
	
	Accounts()
	{
		accountsList.add(100701l);
		accountsList.add(100702l);
		
		accounts.put(100701l, new AccountHolder());
		(accounts.get(100701l)).setName("User1");
		(accounts.get(100701l)).setPin(0000);
		(accounts.get(100701l)).setMobileNumber("0000000000");
		(accounts.get(100701l)).setBalance(25000l);
		(accounts.get(100701l)).setAccountType("savings");
		
		accounts.put(100702l, new AccountHolder());
		(accounts.get(100702l)).setName("User2");
		(accounts.get(100702l)).setPin(1111);
		(accounts.get(100702l)).setMobileNumber("1111111111");
		(accounts.get(100702l)).setBalance(50000l);
		(accounts.get(100702l)).setAccountType("savings");
	}
	
	public void create()
	{
		try
		{
			accounts.put(currentUser,new AccountHolder());
			
			System.out.print("Enter your name :");
			(accounts.get(currentUser)).setName(scan.nextLine());
			
			System.out.print("Enter Age :");
			(accounts.get(currentUser)).setAge(Byte.parseByte(scan.nextLine()));

			System.out.print("Enter Date-Of-Birth :");
			(accounts.get(currentUser)).setDateOfBirth(scan.nextLine());
			
			System.out.print("Enter MobileNumber :");
			(accounts.get(currentUser)).setMobileNumber(scan.nextLine());
			
			System.out.print("Enter PAN number :");
			(accounts.get(currentUser)).setPanNumber(scan.nextLine());
			
			System.out.print("Enter your city :");
			(accounts.get(currentUser)).setBranch(scan.nextLine());
			
			(accounts.get(currentUser)).setPin(createPin());
		
			if((accounts.get(currentUser)).getAge()>=18)
			{
				(accounts.get(currentUser)).setAccountType(setAccount());
			}
			
			else
			{
				(accounts.get(currentUser)).setAccountType("student");
			}
			accountsList.add(currentUser);
			System.out.println(accountsList);
			System.out.println("Account created.!");
			System.out.println("Your account number is "+currentUser);
		}
		
		catch(Exception e)
		{
			System.out.println("");
			System.out.println("Input Wrong.");
			System.out.println("");
		}
	}
	
	/*public String getName()
	{
		String userName=scan.nextLine();
		return userName;
	}*/
	
	public int createPin()
	{
		System.out.print("Enter new 4-digit pin :");
		int pin=(Integer.parseInt(scan.nextLine()));
		boolean allowPin=true;
		if(pin<1000 || pin>9999)
		{
			System.out.println("Your pin must be 4 digit,re-enter your pin :");
			allowPin=false;
		}
		
		if(allowPin)
		{
			System.out.print("Re-Enter your pin :");
			if(pin!=(Integer.parseInt(scan.nextLine())))
			{
				System.out.println("Pin not matched,");
				createPin();
			}
		}
		else 
		{
			createPin();
		}
		return pin;
	}
	
	public String setAccount()
	{
		System.out.println("1.Savings Account (Minimum balance must be 500)");
		System.out.println("2.Salary Account (Minimum balance is 0)");
		
		String option=scan.nextLine();
		
		if(option.equals("1"))
		{
			return "savings";
		}
		
		else if(option.equals("2"))
		{
			return "salary";
		}
		
		else
		{
			System.out.println("Entered option is wrong");
			setAccount();
			return "";
		}
		
	}
	
	public ArrayList<Long> getList()
	{
		return accountsList;
	}
	
	public HashMap<Long,AccountHolder> getMap()
	{
		return accounts;
	}
}
