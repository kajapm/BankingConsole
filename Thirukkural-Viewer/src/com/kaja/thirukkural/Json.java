package com.thirukkural;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONObject; 
import org.json.simple.parser.*; 
import org.json.simple.JSONArray; 

public class Json 
{
	public static JSONArray jsonArray=new JSONArray();
	public void jsonList()
	{
		try {
			Object json=new JSONParser().parse(new FileReader("E:\\programs\\eclipse\\ThirukkuralViewer\\JSON\\Thirukkural.json"));
			JSONObject 	jsonObject=(JSONObject) json;
			jsonArray=(JSONArray)jsonObject.get("kural");		
			
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ParseException e) {
				e.printStackTrace();
			}		
	}
}
