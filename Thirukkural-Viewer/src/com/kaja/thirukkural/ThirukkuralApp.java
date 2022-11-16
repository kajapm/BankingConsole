package com.thirukkural;

public class ThirukkuralApp {
	public static void main(String args[])
	{
		View view=new View();
		Json json=new Json();
		json.jsonList();
		//System.out.println(Json.jsonArray);
		view.mainMenu();
	}

}
