package com.cricket.score;

import java.util.ArrayList;
import java.util.Scanner;

public class GameFunctions
{
	Data data=Data.getInstance();
	Scanner scan=new Scanner(System.in);
	
	public void newTeams()
	{ 
		System.out.println("");
		System.out.println("Enter team 1 player names");
		addTeam(data.team1Players);
		
		System.out.println("");
		System.out.println("Enter team 2 player names");
		addTeam(data.team2Players);
	}
	
	private void addTeam(ArrayList<String> team)
	{
		for(int i=0;i<11;i++)
		{
			String player=scan.nextLine();
			
			if(player.length()==0)
			{
				System.out.println("Enter a valid name.");
				i--;
			}
			
			else if(team.contains(player))
			{
				System.out.println("Player already exist.");
				i--;
			}
			
			else
			{
				team.add(player);
			}
		}
		
		System.out.println("");
		System.out.println("Team players list :");
		System.out.println("");
		
		for(int i=0;i<team.size();i++)
		{
			System.out.println((i+1)+"-"+team.get(i));
		}
	}
	
	public void setOver()
	{
		System.out.println("");
		System.out.print("Enter number of overs :");
		data.overs=Integer.parseInt(scan.nextLine());
	}
	
	public ArrayList<String> selectTeam(ArrayList<String> team)
	{
		System.out.println("");
		System.out.print("Enter option :");
		String option=scan.nextLine();
		
		if(option.equals("1"))
		{
			team=data.indianPlayers;
		}
		
		else if(option.equals("2"))
		{
			team=data.australianPlayers;
		}
		
		else if(option.equals("3"))
		{
			team=data.bangladeshPlayers;
		}
		
		else if(option.equals("4"))
		{
			team=data.southAfricanPlayers;
		}
		
		else if(option.equals("5"))
		{
			team=data.pakistanPlayers;
		}
		
		else if(option.equals("6"))
		{
			team=data.englandPlayers;
		}
		
		else
		{
			System.out.println("Input wrong.");
			selectTeam(team);
		}
		
		System.out.println("");
		System.out.println("Team players list :");
		System.out.println("");
		
		for(int i=0;i<team.size();i++)
		{
			System.out.println((i+1)+"-"+team.get(i));
		}
		
		return team;
	}
	
	public void batting(ArrayList<String> team,ArrayList<NewPlayer> score,ArrayList<ArrayList<String>> over,int totalScore)
	{
		for(int i=0;i<11;i++)
		{
			score.add(new NewPlayer());
		}
		
		byte playerTrack=0;
		byte run=0;
		for(int i=0;i<data.overs;i++)
		{
			data=Data.getInstance();
			over.add(new ArrayList<String>());
			score.get(playerTrack).setStatus("p");
			
			if(playerTrack<11)
			{
				for(int j=0;j<6;j++)
				{
					if(playerTrack<11)
					{
						System.out.println(team.get(playerTrack)+" is batting");
						System.out.println("Press enter to bat "+(i+1)+" Over "+(j+1)+" Ball...");
						scan.nextLine();
						run=(byte) Math.floor(Math.random()*7);
						if(run>0)
						{
							if(run==1)
							{
								System.out.println("Got 1 run....!");
								NewPlayer player=score.get(playerTrack);		
								player.addScore(player.getScoreOfPlayer(), run);
								player.addBalls();
								totalScore+=run;
								over.get(i).add("1");
								System.out.println("Player score is "+player.getScoreOfPlayer());
								System.out.println("Your Team score is "+totalScore);
								System.out.println("");
								System.out.println("");
								
							}
							
							else if(run==2)
							{
								
								System.out.println("Got 2 run....!");
								NewPlayer player=score.get(playerTrack);		
								player.addScore(player.getScoreOfPlayer(), run);
								player.addBalls();
								totalScore+=run;
								over.get(i).add("2");
								System.out.println("Player score is "+player.getScoreOfPlayer());
								System.out.println("Your Team score is "+totalScore);
								System.out.println("");
								System.out.println("");
								
							}
							
							else if(run==3)
							{
								
								System.out.println("Got 3 run....!");
								NewPlayer player=score.get(playerTrack);		
								player.addScore(player.getScoreOfPlayer(), run);
								player.addBalls();
								totalScore+=run;
								over.get(i).add("3");
								System.out.println("Player score is "+player.getScoreOfPlayer());
								System.out.println("Your Team score is "+totalScore);
								System.out.println("");
								System.out.println("");
								
							}
							
							else if(run==4)
							{
								
								System.out.println("Great, 4 run....!");
								NewPlayer player=score.get(playerTrack);		
								player.addScore(player.getScoreOfPlayer(), run);
								player.addBalls();
								player.addFour();
								totalScore+=run;
								over.get(i).add("4");
								System.out.println("Player score is "+player.getScoreOfPlayer());
								System.out.println("Your Team score is "+totalScore);
								System.out.println("");
								System.out.println("");
								
							}
							
							else if(run==5)
							{
								
								System.out.println("Its a Dot ball.");
								NewPlayer player=score.get(playerTrack);
								player.addBalls();
								over.get(i).add("0");
								System.out.println("Player score is "+player.getScoreOfPlayer());
								System.out.println("Your Team score is "+totalScore);
								System.out.println("");
								System.out.println("");
								
							}
							
							else if(run==6)
							{
								
								System.out.println("Extradinory, 6 runs....!");
								NewPlayer player=score.get(playerTrack);		
								player.addScore(player.getScoreOfPlayer(), run);
								player.addBalls();
								player.addSix();
								totalScore+=run;
								over.get(i).add("6");
								System.out.println("Player score is "+player.getScoreOfPlayer());
								System.out.println("Your Team score is "+totalScore);
								System.out.println("");
								System.out.println("");
								
							}
							
						}
						
						else
						{
							
							System.out.println("Player Out.");
							NewPlayer player=score.get(playerTrack);
							player.addBalls();
							over.get(i).add("out");
							player.setStatus("out");
							playerTrack++;
							score.get(playerTrack).setStatus("p");
							
						}
					}
					
					else
					{
						System.out.println("All players are Out.");
						System.out.println("Your team score is "+score);
						break;
					}
				
				}
				
			}
			System.out.println("");
			System.out.println("End of first over");
			System.out.println("\t1st Ball\t2nd Ball\t3rd Ball\t4Th Ball\t5th Ball\t6th Ball");
			for(int k=0;k<over.get(i).size();k++)
			{
				System.out.print("\t"+over.get(i).get(k));
			}
		}
	}
}
