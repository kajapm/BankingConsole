package com.manage.contacts;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class ContactsManipulation
{
	Scanner scan;
	Menu menu;
	ResultSet resultSet;
	DataConnection dataConnection;
	ContactsManipulation()
	{
		scan=new Scanner(System.in);
		dataConnection=DataConnection.getInstance();
	}
	
	public void viewContacts()
	{
		
		try {
			System.out.println("Name\tNumber");
			System.out.println("");
			resultSet=dataConnection.statement.executeQuery("select * from contactslist");
			
			while(resultSet.next())
			{
				System.out.println(resultSet.getString(2)+"\t"+resultSet.getString(3));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Menu menu=new Menu();
		menu.mainMenu();
	}
	
	public void createContact()
	{
		System.out.print("Enter name :");
		String name=scan.nextLine();
		
		System.out.print("Enter number :");
		String number=scan.nextLine();
		
		System.out.println("Contact Type");
		System.out.println("1.Home");
		System.out.println("2.work");
		System.out.println("3.personal");
		System.out.println("4.colleague");
		System.out.println("");
		System.out.print("Enter your option :");
		System.out.println("");
		
		String option=scan.nextLine();
		String type="";
		if(option.equals("1"))
		{
			type="home";
		}
		
		else if(option.equals("2"))
		{
			type="work";
		}
		
		else if(option.equals("3"))
		{
			type="personal";
		}
		
		else if(option.equals("4"))
		{
			type="colleague";
		}
		
		else
		{
			System.out.println("Input wrong");
			createContact();
		}
		
		try {
			String query=("insert into contactslist (contactname,contactnumber,contacttype) values ('"+name+"','"+number+"','"+type+"')");
			PreparedStatement ps=dataConnection.connection.prepareStatement(query);
			ps.executeUpdate();
					
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.toString());;
		}
		System.out.println("contact saved");
		menu=new Menu();
		menu.mainMenu();
	}
	
	public void searchContact()
	{
		System.out.println("Enter contact name");
		String name=scan.nextLine();
		try {
			resultSet=dataConnection.statement.executeQuery("select * from contactslist");
	
		System.out.println("Name\tNumber");
		System.out.println("");
		
		while(resultSet.next())
		{
			if(resultSet.getString(2).contains(name))
			{
				System.out.println(resultSet.getString(2)+"\t"+resultSet.getString(3));
			}
		}
		
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
		menu=new Menu();
		menu.mainMenu();
	}
	
	public void viewByType()
	{
		System.out.println("Select your type :");
		
		System.out.println("Contact Type");
		System.out.println("1.Home");
		System.out.println("2.work");
		System.out.println("3.personal");
		System.out.println("4.colleague");
		System.out.println("");
		System.out.print("Enter your option :");
		System.out.println("");
		
		String option=scan.nextLine();
		String type="";
		if(option.equals("1"))
		{
			type="home";
		}
		
		else if(option.equals("2"))
		{
			type="work";
		}
		
		else if(option.equals("3"))
		{
			type="personal";
		}
		
		else if(option.equals("4"))
		{
			type="colleague";
		}
		
		else
		{
			System.out.println("Input wrong");
			viewByType();
		}
		
		try {
			resultSet=dataConnection.statement.executeQuery("select * from contactslist");
	
		System.out.println("Name\tNumber");
		System.out.println("");
		
		while(resultSet.next())
		{
			if(resultSet.getString(4).equals(type))
			{
				System.out.println(resultSet.getString(2)+"\t"+resultSet.getString(3));
			}
		}
		
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
		menu=new Menu();
		menu.mainMenu();
	}
	
	public void deleteContact()
	{
		System.out.println("1.View all contacts");
		System.out.println("2.search contact");
		System.out.println("");
		System.out.print("Enter your option :");
		System.out.println("");
		
		String option=scan.nextLine();
		if(option.equals("1"))
		{
			try {
				System.out.println("ID\tName\tNumber");
				System.out.println("");
				resultSet=dataConnection.statement.executeQuery("select * from contactslist");
				
				while(resultSet.next())
				{
					System.out.println(resultSet.getString(1)+"\t"+resultSet.getString(2)+"\t"+resultSet.getString(3));
				}
				
				System.out.println("");
				System.out.print("Enter id to delete :");
				
				int id=Integer.parseInt(scan.nextLine());
				
				String query=("delete from contactslist where id="+id);
				PreparedStatement ps=dataConnection.connection.prepareStatement(query);
				ps.executeUpdate();
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println(e.toString());
				System.out.println("Incorrect input.");
				menu=new Menu();
				menu.mainMenu();
			}
			
			System.out.println("Contact deleted");
			menu=new Menu();
			menu.mainMenu();
		}
		
		else if(option.equals("2"))
		{
			System.out.println("Enter contact name");
			String name=scan.nextLine();
			try {
				resultSet=dataConnection.statement.executeQuery("select * from contactslist");
		
			System.out.println("ID\tName\tNumber");
			System.out.println("");
			
			while(resultSet.next())
			{
				if(resultSet.getString(2).contains(name))
				{
					System.out.println(resultSet.getString(1)+"\t"+resultSet.getString(2)+"\t"+resultSet.getString(3));
				}
				
				System.out.print("Enter id to delete :");
				
				int id=Integer.parseInt(scan.nextLine());
				
				String query=("delete from contactslist where id="+id);
				PreparedStatement ps=dataConnection.connection.prepareStatement(query);
				ps.executeUpdate();
			}
			
			} catch (SQLException e) 
			{
				System.out.println(e.toString());
				System.out.println("Incorrect input.");
				menu=new Menu();
				menu.mainMenu();
			}
			
			System.out.println("Contact deleted");
			menu=new Menu();
			menu.mainMenu();
		}
	}
}
