package com.bank;

import java.util.HashMap;
import java.util.Scanner;

public class Admin extends Banking
{
	Scanner scan=new Scanner(System.in);
	
	public void adminPage()
	{
		System.out.println("- - - - - - - - - - - - -");
		System.out.println("");
		System.out.println("1.Customer details.");
		System.out.println("2.Account Number through mobile number.");
		System.out.println("3.Edit customer details.");
		System.out.println("4.Logout");
		System.out.println("");
		System.out.println("- - - - - - - - - - - - -");
		
		adminPageOptions();
		
	}
	
	public void adminPageOptions()
	{
		System.out.print("Enter Option :");
		String option=scan.nextLine();
		if(option.equals("1"))
			printDetails();
		
		else if(option.equals("2"))
			accountNumberFind();
		
		else if(option.equals("3"))
			editCustomerInfo();
		
		else if(option.equals("4"))
			login();
		
		else
		{
			System.out.println("Input incorrect");
			adminPage();  
		}
	}
	
	private void printDetails() 
	{
		try 
		{
			System.out.print("Enter Account Number :");
			long id=Long.parseLong(scan.nextLine());
			System.out.println(accountsObj.accountsList);
			
			if(!accountsObj.accountsList.contains(id))
			{
				System.out.println("User not found,");
				adminPage();
			}
			System.out.println("- - - - - - - - - - - - -");
			System.out.println("");
			System.out.println("Account holder name :"+(accountsObj.accounts.get(id)).getName()); 
			System.out.println("Account number :"+id);
			System.out.println("Date-Of-Birth :"+(accountsObj.accounts.get(id)).getDateOfbirth());
			System.out.println("Age :"+(accountsObj.accounts.get(id)).getAge());
			System.out.println("Mobile Number :"+(accountsObj.accounts.get(id)).getMobileNumber());
			System.out.println("Pan no :"+(accountsObj.accounts.get(id)).getPanNumber());
			System.out.println("Account Type :"+(accountsObj.accounts.get(id)).getAccountType());
			System.out.println("Account Balance :"+(accountsObj.accounts.get(id)).getBalance());
			System.out.println("Account Balance :"+(accountsObj.accounts.get(id)).getBranch());
			System.out.println("");
			System.out.println("- - - - - - - - - - - - -");
			
			
			adminPage();
			
		}
		
		catch(Exception e)
		{
			System.out.println("Incorrect Input.");
			adminPageOptions();
		}
		
	}
	
	private void accountNumberFind() 
	{
		System.out.print("Enter mobile number :");
		System.out.println("");
		System.out.println("Your result :"+searchAccountNumber());
		System.out.println("");
		System.out.println("- - - - - - - - - - - - -");
		adminPage();
	}
	
	private void editCustomerInfo() 
	{
		System.out.println("- - - - - - - - - - - - -");
		System.out.println("");
		System.out.println("1.Change name.");
		System.out.println("2.Change dob.");
		System.out.println("3.Change PAN no.");
		System.out.println("4.Change Age.");
		System.out.println("5.Mobile number.");
		System.out.println("6.Admin main page.");
		System.out.println("");
		System.out.println("- - - - - - - - - - - - -");
		editCustomerOptions();
	}
	
	public void editCustomerOptions()
	{
		System.out.print("Enter option :");
		String option=scan.nextLine();
		
		if(option.equals("1"))
			changeName();
		
		else if(option.equals("2"))
			changeDOB();
		
		else if(option.equals("3"))
			changePAN();
		
		else if(option.equals("4"))
			changeAge();
		
		else if(option.equals("5"))
			changeMobileNumber();
		
		else if(option.equals("6"))
			adminPage();
		
		else
		{
			System.out.println("Input incorrect,");
			editCustomerInfo();
		}
	}
	
	public void changeName()
	{
			System.out.print("Enter account no :");
			Long id=Long.parseLong(scan.nextLine());
			
			if(!(accountsObj.accountsList).contains(id))
			{
				System.out.println("User not found");
				editCustomerInfo();
			}
			System.out.print("Enter new name :");
			(accountsObj.accounts.get(id)).setName(scan.nextLine());
			System.out.println("Name successfully changed");
			editCustomerInfo();
	}
	
	public void changeDOB()
	{
			System.out.print("Enter account no :");
			Long id=Long.parseLong(scan.nextLine());
			
			if(!(accountsObj.accountsList).contains(id))
			{
				System.out.println("User not found");
				editCustomerInfo();
			}
			System.out.print("Enter new DOB :");
			(accountsObj.accounts.get(id)).setDateOfBirth(scan.nextLine());
			System.out.println("DOB successfully changed");
			editCustomerInfo();
	}
	
	public void changePAN()
	{
			System.out.print("Enter account no :");
			Long id=Long.parseLong(scan.nextLine());
			
			if(!(accountsObj.accountsList).contains(id))
			{
				System.out.println("User not found");
				editCustomerInfo();
			}
			System.out.print("Enter new PAN :");
			(accountsObj.accounts.get(id)).setPanNumber(scan.nextLine());
			System.out.println("PAN no successfully changed");
			editCustomerInfo();
	}
	
	public void changeAge()
	{
		try
		{
			System.out.print("Enter account no :");
			Long id=Long.parseLong(scan.nextLine());
			
			if(!(accountsObj.accountsList).contains(id))
			{
				System.out.println("User not found");
				editCustomerInfo();
			}
			System.out.print("Enter Age :");
			(accountsObj.accounts.get(id)).setAge(Byte.parseByte(scan.nextLine()));
			System.out.println("Age successfully changed");
			editCustomerInfo();
		}
		
		catch(Exception e)
		{
			System.out.println("Input incorrect");
			editCustomerInfo();
		}
	}
	
	public void changeMobileNumber()
	{
			System.out.print("Enter account no :");
			Long id=Long.parseLong(scan.nextLine());
			
			if(!(accountsObj.accountsList).contains(id))
			{
				System.out.println("User not found");
				editCustomerInfo();
			}
			System.out.print("Enter new name :");
			(accountsObj.accounts.get(id)).setMobileNumber(scan.nextLine());
			System.out.println("Mobile number successfully changed");
			editCustomerInfo();
	}
	
	public String searchAccountNumber()
	{
		String mobileNumber=scan.nextLine();
		for(HashMap.Entry<Long,AccountHolder> entry: accountsObj.accounts.entrySet())
		{
			if((entry.getValue()).getMobileNumber().equals(mobileNumber))
			{
				return String.valueOf(entry.getKey());
			}
		}
		return "Not Found";
	}	
}
