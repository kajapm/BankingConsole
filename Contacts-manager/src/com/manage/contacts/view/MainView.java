package com.kaja.contactsmanager.view;

import java.util.Scanner;

import com.kaja.contactsmanager.controller.ContactsManipulation;

public class MainView
{
	ContactsManipulation contactsManipulation;
	MainView()
	{
		contactsManipulation=new ContactsManipulation(this);
	}
	private Scanner scan=new Scanner(System.in);
	
	public void mainMenu()
	{
		System.out.println("");
		System.out.println("1.View contacts");
		System.out.println("2.Create contacts");
		System.out.println("3.Search contacts");
		System.out.println("4.view contacts by type");
		System.out.println("5.Delete contact");
		System.out.println("6.Exit");
		System.out.println("");
		System.out.print("Enter your option :");
		System.out.println("");
		
		String option=scan.nextLine();
		
		if(option.equals("1"))
		{
			contactsManipulation.viewContacts();
		}
		
		else if(option.equals("2"))
		{
			contactsManipulation.createContact();
		}
		
		else if(option.equals("3"))
		{
			contactsManipulation.searchContact();
		}
		
		else if(option.equals("4"))
		{
			contactsManipulation.viewByType();
		}
		
		else if(option.equals("5"))
		{
			contactsManipulation.deleteContact();
		}
		
		else if(option.equals("6"))
		{
			System.out.println("Thank You!");
		}
		
		else 
		{
			System.out.println("Incorrect input");
			mainMenu();
		}
	}
}