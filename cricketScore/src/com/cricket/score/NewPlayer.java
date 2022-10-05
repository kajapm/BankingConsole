package com.cricket.score;

public class NewPlayer 
{
	private int sixes=0;
	private int fours=0;
	private int balls=0;
	private int scoreOfPlayer=0;
	private String status="not out";
	
	
	public void addSix()
	{
		sixes++;
	}
	public void addFour()
	{
		fours++;
	}
	public void addBalls()
	{
		balls++;
	}
	public void addScore(int playerScore,int score)
	{	
		 scoreOfPlayer=playerScore+score;
	}
	public int getScoreOfPlayer() 
	{
		return scoreOfPlayer;
	}
	public int getSix()
	{
		return sixes;
	}
	public int getFour()
	{
		return fours;
	}
	public int getBalls()
	{
		return balls;
	}
	public String getStatus()
	{
		return status;
	}
	public void setStatus(String playerStatus)
	{
		status=playerStatus;
	}
}
