package com.cricket.score;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Data 
{
	static Data data;
	
	public static Data getInstance()
	{
		if(data==null)
		{
			data=new Data();
		}
		
		return data;
	}
	
	Scanner scan=new Scanner(System.in);
	
	int overs;
	
	int team1TotalScore;
	int team2TotalScore;;
	
	ArrayList<NewPlayer> team1Score=new ArrayList<NewPlayer>();
	ArrayList<NewPlayer> team2Score=new ArrayList<NewPlayer>();
	
	ArrayList<String> indianPlayers=new ArrayList<String>(Arrays.asList("sachin","virat","dhoni","rohit","rahul","dinesh","yuvraj","aswin","jadeja","dravid","sehwag"));
	ArrayList<String> australianPlayers=new ArrayList<String>(Arrays.asList("warner","smith","finch","cummins","maxwell","wade","starc","hazlwud","mitchel","stoinis","watson"));
	ArrayList<String> bangladeshPlayers=new ArrayList<String>(Arrays.asList("shakib","rafique","hasan","iqbal","haque","kayes","hossain","sabbir","taskin","litton","saifu"));
	ArrayList<String> southAfricanPlayers=new ArrayList<String>(Arrays.asList("ABDe","DeKock","kallis","smith","markem","rabada","boucher","DuPlesi","pollock","steyn","amla"));
	ArrayList<String> pakistanPlayers=new ArrayList<String>(Arrays.asList("azam","riswan","zaman","hafeez","naseem","shadab","kushdil","nawaz","asif","haider","rauf"));
	ArrayList<String> englandPlayers=new ArrayList<String>(Arrays.asList("stokes","bairsto","buttler","moeen","root","andrson","alister","brook","morgan","woakes","alex"));
	
	ArrayList<String> team1Players=new ArrayList<String>();
	ArrayList<String> team2Players=new ArrayList<String>();
	
	ArrayList<ArrayList<String>> team1Overs=new ArrayList<ArrayList<String>>();
	ArrayList<ArrayList<String>> team2Overs=new ArrayList<ArrayList<String>>();
	
}
 