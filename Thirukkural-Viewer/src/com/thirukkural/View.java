package com.thirukkural;

public class View {
	
	
	void mainMenu()
	{
		System.out.println("Thirukkural Viewer.!");
		System.out.println("");
		System.out.println("1.View all Thirukkural");
		System.out.println("2.View Thirukkural by number");
		System.out.println("3.View Thirukkural by ");
		System.out.println("3.Exit");
		
		Operations operations=new Operations();
		operations.printVerses();
	}
  }
