package com.cricket.score;

import java.util.Scanner;

public class View extends GameFunctions
{
	Scanner scan=new Scanner(System.in);
	private Data data;
	
	public void mainPage()
	{
		System.out.println("\t\tCricket Game.!");
		System.out.println("1.Play Game");
		System.out.println("2.Exit Game");
		System.out.println("");
		System.out.println("Enter your Option...:");
		String option=scan.nextLine();
		
		if(option.equals("1"))
		{
			teamSelection();
		}
		else if(option.equals("2"))
		{
			System.out.println("");
			System.out.println("Thank You");
		}
		else
		{
			System.out.println("");
			System.out.println("Wrong input.");
			mainPage();
		}
	}
	private void teamSelection()
	{
		System.out.println("\t\tCricket Game.!");
		System.out.println("1.Create team");
		System.out.println("2.Select existing team");
		System.out.println("");
		System.out.println("Enter your Option...:");
		String option=scan.nextLine();
		
		if(option.equals("1"))
		{
			newTeams();
			setOver();
			chooseBatting();
		}
		else if(option.equals("2"))
		{
			data=Data.getInstance();
			
			System.out.println("Select Team 1 :");
			defaultTeams();
			System.out.println("");
			data.team1Players=selectTeam(data.team1Players);
			
			System.out.println("");
			System.out.println("Select Team 2 :");
			defaultTeams();
			System.out.println("");
			data.team2Players= selectTeam(data.team2Players);
			
			while(data.team1Players.get(0).equals(data.team2Players.get(0)))
			{
				System.out.println("");
				System.out.println("Team1 and Team2 not be same.");
				System.out.println("");
				defaultTeams();
				data.team2Players= selectTeam(data.team2Players);
			}
			setOver();
			chooseBatting();
		}
		else
		{
			System.out.println("");
			System.out.println("Wrong input.");
			teamSelection();
		}
	}
	
	private void defaultTeams()
	{
		System.out.println("");
		System.out.println("1.Indian Team");
		System.out.println("2.Australia Team");
		System.out.println("3.Bangladesh Team");
		System.out.println("4.South Africa Team");
		System.out.println("5.Pakistan Team");
		System.out.println("6.England Team");
	}
	private void scoreMenu()
	{
		data=Data.getInstance();
		
		System.out.println("");
		System.out.println("1.Team score");
		System.out.println("2.Team over");
		System.out.println("3.Exit");
		System.out.println("");
		System.out.print("Enter option :");
		String option=scan.nextLine();
		
		if(option.equals("1"))
		{
			System.out.println("");
			System.out.println("Team 1 score.");
			System.out.println("Team 2 score.");
			System.out.println("");
			System.out.println("Enter your option");
			option=scan.nextLine();
			if(option.equals("1"))
			{
				showScore(data.team1Score,data.team1Players);
				scoreMenu();
			}
			else if(option.equals("2"))
			{
				showScore(data.team2Score,data.team2Players);
				scoreMenu();
			}
			else
			{
				System.out.println("Input incorrect.");
				scoreMenu();
			}
		}
		else if(option.equals("2"))
		{
			System.out.println("");
			System.out.println("Team 1 overs.");
			System.out.println("Team 2 overs.");
			System.out.println("");
			System.out.println("Enter your option");
			option=scan.nextLine();
			if(option.equals("1"))
			{
				showOvers(data.team1Overs);
				scoreMenu();
			}
			else if(option.equals("2"))
			{
				showOvers(data.team2Overs);
				scoreMenu();
			}
			else
			{
				System.out.println("Input incorrect.");
				scoreMenu();
			}
		}
		else if(option.equals("3"))
		{
			System.out.println("");
			System.out.println("Game Exitted.");
		}
				else
		{
			System.out.println("Input incorrect");
			scoreMenu();
		}	
	}
	private void chooseBatting()
	{
		System.out.println("");
		System.out.println("Which team wants to bat first");
		System.out.println("1.Team 1");
		System.out.println("2.Team 2");
		System.out.println("3.Toss");
		System.out.println("");
		System.out.print("Enter your option:");
		String option=scan.nextLine();
		
		if(option.equals("1"))
		{
			System.out.println("");
			System.out.println("Team 1 is batting.!");
			System.out.println("");
			data.team1TotalScore= batting(data.team1Players,data.team1Score,data.team1Overs);
			
			System.out.println("");
			System.out.println("Team 2 is batting.!");
			System.out.println("");
			data.team2TotalScore= batting(data.team2Players,data.team2Score,data.team2Overs);
		
			showWonTeam();
			scoreMenu();
		}
		else if(option.equals("2"))
		{
			System.out.println("");
			System.out.println("Team 2 is batting.!");
			System.out.println("");
			data.team2TotalScore=batting(data.team2Players,data.team2Score,data.team2Overs);
			
			System.out.println("");
			System.out.println("Team 1 is batting.!");
			System.out.println("");
			data.team1TotalScore=batting(data.team1Players,data.team1Score,data.team1Overs);
		
			showWonTeam();
			scoreMenu();
		}
		else if(option.equals("3"))
		{
			int toss=(int)Math.ceil((Math.random())*2);
			if(toss==1)
			{
				System.out.println("");
				System.out.println("Team 1 is batting.!");
				System.out.println("");
				data.team1TotalScore=batting(data.team1Players,data.team1Score,data.team1Overs);
				
				System.out.println("");
				System.out.println("Team 2 is batting.!");
				System.out.println("");
				data.team2TotalScore=batting(data.team2Players,data.team2Score,data.team2Overs);
			
				showWonTeam();
				scoreMenu();
			}
			else if(toss==2)
			{
				System.out.println("");
				System.out.println("Team 2 is batting.!");
				System.out.println("");
				data.team2TotalScore=batting(data.team2Players,data.team2Score,data.team2Overs);
				
				System.out.println("");
				System.out.println("Team 1 is batting.!");
				System.out.println("");
				data.team1TotalScore=batting(data.team1Players,data.team1Score,data.team1Overs);
			
				showWonTeam();
				scoreMenu();
			}
			else
			{
				System.out.println("");
				System.out.println("Wrong input.");
				chooseBatting();
			}
		}
	}
}
