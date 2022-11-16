package com.kaja.contactsmanager.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DataConnection 
{
	public static DataConnection dataConnection;
	public Connection connection;
	public Statement statement;
	private DataConnection()
	{
		try 
		{
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/contacts","root","wasd");
			statement=connection.createStatement();
		}
		catch(Exception e)
		{
			System.out.println(e.toString());
		}
	}
	
	public static DataConnection getInstance()
	{
		if(dataConnection==null)
		dataConnection=new DataConnection();
		
		return dataConnection;
	}
}