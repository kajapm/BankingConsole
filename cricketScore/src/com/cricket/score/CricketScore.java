package com.cricket.score;

public class CricketScore extends Thread
{
	@SuppressWarnings("resource")
	public static void main(String args[])
	{
		
		View view=new View();
		view.mainPage();
		
		/*if(page==1)
		{
			
			System.out.println("\t\tCricket Game.!");
			System.out.println("1.Indian Team");
			System.out.println("2.Australia Team");
			System.out.println("3.Bangladesh Team");
			System.out.println("4.South Africa Team");
			System.out.println("2.Pakistan Team");
			System.out.println("2.England Team");
			
			System.out.println("");
			System.out.println("Select player1 Team :");
			int team=scan.nextInt();
			
			if(team==1)
			{
				playersArray=india.clone();
			}
			
			else if(team==2)
			{
				playersArray=australia.clone();
			}
			
			else if(team==3)
			{
				playersArray=bangladesh.clone();
			}
			
			else if(team==4)
			{
				playersArray=southAfrica.clone();
			}
			
			else if(team==5)
			{
				playersArray=pakistan.clone();
			}
			
			else if(team==6)
			{
				playersArray=england.clone();
			}
			
			System.out.println("\t\tCricket Game.!");
			System.out.println("1.Indian Team");
			System.out.println("2.Australia Team");
			System.out.println("3.Bangladesh Team");
			System.out.println("4.South Africa Team");
			System.out.println("2.Pakistan Team");
			System.out.println("2.England Team");
			
			System.out.println("");
			System.out.println("Select player2 Team :");
			team=scan.nextInt();
			
			if(team==1)
			{
				playersArray2=india.clone();
			}
			Driver
			else if(team==2)
			{
				playersArray2=australia.clone();
			}
			
			else if(team==3)
			{
				playersArray2=bangladesh.clone();
			}
			
			else if(team==4)
			{
				playersArray=southAfrica.clone();
			}
			
			else if(team==5)
			{
				playersArray2=pakistan.clone();
			}
			
			else if(team==6)
			{
				playersArray2=england.clone(); 
			}
			
			for(int i=0;i<11;i++)
			{
				playerScores.put(playersArray[i],new Players());
				playerScores2.put(playersArray2[i],new Players());
			}	
			
			System.out.println("\t\tCricket Game");
			System.out.println("Enter no of overs :");
			overs=scan.nextInt();
			
			Overs oversObj=new Overs();
			//oversObj.player1Overs=String[overs][6];
			//oversObj.player2Overs=String[overs][6];
			
			scan.nextLine();
		
		for(int i=0;i<overs;i++)
		{
			if(playerTrack<11)
			{
				for(int j=0;j<6;j++)
				{
					if(playerTrack<11)
					{
						System.out.println(playersArray[playerTrack]+" is batting");
						System.out.println("Press enter to bat "+(i+1)+" Over "+(j+1)+" Ball...");
						scan.nextLine();
						tempScore=(int) Math.floor(Math.random()*7);
						if(tempScore>0)
						{
							if(tempScore==1)
							{
								System.out.println("Got 1 run....!");
								Players playerScore=playerScores.get(playersArray[playerTrack]);		
								playerScore.addScore(playerScore.getScoreOfPlayer(), tempScore);
								playerScore.addBalls();
								score+=tempScore;
								//oversObj.player1Overs[i][j]="1";
								System.out.println("Player score is "+playerScore.getScoreOfPlayer());
								System.out.println("Your Team score is "+score);
								System.out.println("");
								System.out.println("");
								
							}
							
							else if(tempScore==2)
							{
								
								System.out.println("Got 2 runs....!");
								Players playerScore=playerScores.get(playersArray[playerTrack]);
								playerScore.addScore(playerScore.getScoreOfPlayer(), tempScore);
								playerScore.addBalls();
								score+=tempScore;
								//oversObj.player1Overs[i][j]="2";
								System.out.println("Player score is "+playerScore.getScoreOfPlayer());
								System.out.println("Your Team score is "+score);
								System.out.println("");
								System.out.println("");
								
							}
							
							else if(tempScore==3)
							{
								
								System.out.println("Got 3 runs....!");
								Players playerScore=playerScores.get(playersArray[playerTrack]);
								playerScore.addScore(playerScore.getScoreOfPlayer(), tempScore);
								playerScore.addBalls();
								score+=tempScore;
								//oversObj.player1Overs[i][j]="3";
								System.out.println("Player score is "+playerScore.getScoreOfPlayer());
								System.out.println("Your Team score is "+score);
								System.out.println("");
								System.out.println("");
								
							}
							
							else if(tempScore==4)
							{
								
								System.out.println("Great,Got 4 runs....!");
								Players playerScore=playerScores.get(playersArray[playerTrack]);
								playerScore.addScore(playerScore.getScoreOfPlayer(), tempScore);
								playerScore.addFour();
								playerScore.addBalls();
								score+=tempScore;
								//oversObj.player1Overs[i][j]="4";
								System.out.println("Player score is "+playerScore.getScoreOfPlayer());
								System.out.println("Your Team score is "+score);
								System.out.println("");
								System.out.println("");
								
							}
							
							else if(tempScore==5)
							{
								
								System.out.println("Its a Dot ball.");
								Players playerScore=playerScores.get(playersArray[playerTrack]);
								playerScore.addBalls();
								//oversObj.player1Overs[i][j]="Dot";
								System.out.println("Player score is "+playerScore.getScoreOfPlayer());
								System.out.println("Your Team score is "+score);
								System.out.println("");
								System.out.println("");
								
							}
							
							else if(tempScore==6)
							{
								
								System.out.println("Extrodinary, 6 runs....!");
								Players playerScore=playerScores.get(playersArray[playerTrack]);
								playerScore.addScore(playerScore.getScoreOfPlayer(), tempScore);
								playerScore.addSix();
								playerScore.addBalls();
								score+=tempScore;
								//oversObj.player1Overs[i][j]="6";
								System.out.println("Player score is "+playerScore.getScoreOfPlayer());
								System.out.println("Your Team score is "+score);
								System.out.println("");
								System.out.println("");
								
							}
							
						}
						
						else
						{
							
							System.out.println("Player Out.");
							Players playerScore=playerScores.get(playersArray[playerTrack]);
							playerScore.addBalls();
							//oversObj.player1Overs[i][j]="Out";
							playerTrack++;
							
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
		}
		
		System.out.println("");
		System.out.println("");
		System.out.println("Players\t\tScore\tFours\tSixes\tBalls");
		System.out.println("");
		for(Map.Entry<String,Players> entry: playerScores.entrySet())
		{
			Players getClass=entry.getValue();
			System.out.println(entry.getKey()+"\t\t  "+getClass.getScoreOfPlayer()+"\t  "+getClass.getFour()+"\t  "+getClass.getSix()+"\t  "+getClass.getBalls());
			
		}
		
		playerTrack=0;
		
		for(int i=0;i<overs;i++)
		{
			if(playerTrack<11)
			{
				for(int j=0;j<6;j++)
				{
					if(playerTrack<11)
					{
						System.out.println(playersArray2[playerTrack]+" is batting");
						System.out.println("Press enter to bat "+(i+1)+" Over "+(j+1)+" Ball...");
						scan.nextLine();
						tempScore=(int) Math.floor(Math.random()*7);
						if(tempScore>0)
						{
							if(tempScore==1)
							{
								System.out.println("Got 1 run....!");
								Players playerScore=playerScores2.get(playersArray2[playerTrack]);		
								playerScore.addScore(playerScore.getScoreOfPlayer(), tempScore);
								playerScore.addBalls();
								score2+=tempScore;
								//oversObj.player2Overs[i][j]="1";
								System.out.println("Player score is "+playerScore.getScoreOfPlayer());
								System.out.println("Your Team score is "+score2);
								System.out.println("");
								System.out.println("");
								
							}
							
							else if(tempScore==2)
							{
								System.out.println("Got 2 runs....!");
								Players playerScore=playerScores2.get(playersArray2[playerTrack]);
								playerScore.addScore(playerScore.getScoreOfPlayer(), tempScore);
								playerScore.addBalls();
								score2+=tempScore;
								//oversObj.player2Overs[i][j]="2";
								System.out.println("Player score is "+playerScore.getScoreOfPlayer());
								System.out.println("Your Team score is "+score2);
								System.out.println("");
								System.out.println("");
								
							}
							
							else if(tempScore==3)
							{
								System.out.println("Got 3 runs....!");
								Players playerScore=playerScores2.get(playersArray2[playerTrack]);
								playerScore.addScore(playerScore.getScoreOfPlayer(), tempScore);
								playerScore.addBalls();
								score2+=tempScore;
								//oversObj.player2Overs[i][j]="3";
								System.out.println("Player score is "+playerScore.getScoreOfPlayer());
								System.out.println("Your Team score is "+score2);
								System.out.println("");
								System.out.println("");
								
							}
							
							else if(tempScore==4)
							{
								System.out.println("Great,Got 4 runs....!");
								Players playerScore=playerScores2.get(playersArray2[playerTrack]);
								playerScore.addScore(playerScore.getScoreOfPlayer(), tempScore);
								playerScore.addFour();
								playerScore.addBalls();
								score2+=tempScore;
								//oversObj.player2Overs[i][j]="4";
								System.out.println("Player score is "+playerScore.getScoreOfPlayer());
								System.out.println("Your Team score is "+score2);
								System.out.println("");
								System.out.println("");
							
							}
							
							else if(tempScore==5)
							{
								System.out.println("Its a Dot ball.");
								Players playerScore=playerScores2.get(playersArray2[playerTrack]);
								playerScore.addBalls();
								//oversObj.player2Overs[i][j]="0";
								System.out.println("Player score is "+playerScore.getScoreOfPlayer());
								System.out.println("Your Team score is "+score2);
								System.out.println("");
								System.out.println("");
								
							}
							
							else if(tempScore==6)
							{
								System.out.println("Extrodinary, 6 runs....!");
								Players playerScore=playerScores2.get(playersArray2[playerTrack]);
								playerScore.addScore(playerScore.getScoreOfPlayer(), tempScore);
								playerScore.addSix();
								playerScore.addBalls();
								score2+=tempScore;
								//oversObj.player2Overs[i][j]="6";
								System.out.println("Player score is "+playerScore.getScoreOfPlayer());
								System.out.println("Your Team score is "+score);
								System.out.println("");
								System.out.println("");
								
							}
							else
							{
								
								System.out.println("Player Out.");
								Players playerScore=playerScores.get(playersArray[playerTrack]);
								playerScore.addBalls();
								//oversObj.player2Overs[i][j]="Out";
								playerTrack++;
								
							}
							
						}
					}
				}
			}
		}
		
		if(score>score2)
		{
			System.out.println("");
			System.out.println("Player 1 score :"+score);
			System.out.println("Player 2 score :"+score2);
			System.out.println("");
			System.out.println("Player 1 wins.!");
		}
		
		else if(score<score2)
		{
			System.out.println("");
			System.out.println("Player 1 score :"+score);
			System.out.println("Player 2 score :"+score2);
			System.out.println("");
			System.out.println("Player 2 wins.!");
		}
		
		
		System.out.println("1.Score Details.");
		System.out.println("2.Over Details.");
		System.out.println("3.Exit.");
		
		byte num=scan.nextByte();
		
				
		if(num<=3)
		{
			if(num==1)
			{
				System.out.println("1.Player 1");
				System.out.println("2.Player 2");
				if(num<2)
				{
					if(num==1)
					{
						for(Map.Entry<String,Players> entry: playerScores.entrySet())
						{
							Players getClass=entry.getValue();
							System.out.println(entry.getKey()+"\t\t  "+getClass.getScoreOfPlayer()+"\t  "+getClass.getFour()+"\t  "+getClass.getSix()+"\t  "+getClass.getBalls());
							
						}
					}
					
					else if(num==2)
					{
						for(Map.Entry<String,Players> entry: playerScores2.entrySet())
						{
							Players getClass=entry.getValue();
							System.out.println(entry.getKey()+"\t\t  "+getClass.getScoreOfPlayer()+"\t  "+getClass.getFour()+"\t  "+getClass.getSix()+"\t  "+getClass.getBalls());
							
						}
					}
					
					else
					{
						System.out.println("Enter correct input :");
					}
				}
			}
			
			else if(num==2)
			{
				System.out.println("1.Player 1 overs");
				System.out.println("2.Player 2 overs");
				
				num=scan.nextByte();
				if(num==1)
				{
					for(int i=0;i<11;i++)
					{
						for(int j=0;j<6;j++)
						{
							System.out.print(oversObj.player1Overs[i][j]);
						}
						System.out.println("");
					}
				}
				
				else if(num==2)
				{
					for(int i=0;i<11;i++)
					{
						for(int j=0;j<6;j++)
						{
							System.out.print(oversObj.player2Overs[i][j]);
						}
						System.out.println("");
					}
				}
				
			}
		}
		else
		{
			System.out.println("Enter correct input :");
		}
		
		System.out.println("");
		System.out.println("");
		System.out.println("Players\t\tScore\tFours\tSixes\tBalls");
		System.out.println("");
		for(Map.Entry<String,Players> entry: playerScores2.entrySet())
		{
			Players getClass=entry.getValue();
			System.out.println(entry.getKey()+"\t\t  "+getClass.getScoreOfPlayer()+"\t  "+getClass.getFour()+"\t  "+getClass.getSix()+"\t  "+getClass.getBalls());
			
		}
		
	}

		else
		{
			
			System.out.println("Thank You..!");
		}
					
}*/
	}
}