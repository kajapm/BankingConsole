package com.kaja.cricketcalculator.repositary;

import java.util.ArrayList;
import java.util.HashMap;

import com.kaja.cricketcalculator.model.Batsman;
import com.kaja.cricketcalculator.model.Bowler;
import com.kaja.cricketcalculator.model.TeamScore;

public class CricketDatabase {
	
	static CricketDatabase cricketDatabase;
	private HashMap<String,TeamScore> teams;
	private ArrayList<Batsman> team1BatsmanList;
	private ArrayList<Batsman> team2BatsmanList;
	private ArrayList<Bowler> team1BowlerList;
	private ArrayList<Bowler> team2BowlerList;
	private String[] inputs;
	
	private CricketDatabase(){
		teams=new HashMap<String,TeamScore>();
		team1BatsmanList=new ArrayList<Batsman>();
		team2BatsmanList=new ArrayList<Batsman>();
		team1BowlerList=new ArrayList<Bowler>();
		team2BowlerList=new ArrayList<Bowler>();
	}
	
	public static CricketDatabase getInstance()
	{
		if(cricketDatabase==null)
		{
			cricketDatabase=new CricketDatabase();
		}
		return cricketDatabase;
	}

	public HashMap<String, TeamScore> getTeams() {
		return teams;
	}

	public ArrayList<Batsman> getTeam1BatsmanList() {
		return team1BatsmanList;
	}

	public ArrayList<Batsman> getTeam2BatsmanList() {
		return team2BatsmanList;
	}

	public ArrayList<Bowler> getTeam1BowlerList() {
		return team1BowlerList;
	}

	public ArrayList<Bowler> getTeam2BowlerList() {
		return team2BowlerList;
	}

	public void setTeams(HashMap<String, TeamScore> teams) {
		this.teams = teams;
	}

	public void setTeam1BatsmanList(ArrayList<Batsman> team1BatsmanList) {
		this.team1BatsmanList = team1BatsmanList;
	}

	public void setTeam2BatsmanList(ArrayList<Batsman> team2BatsmanList) {
		this.team2BatsmanList = team2BatsmanList;
	}

	public void setTeam1BowlerList(ArrayList<Bowler> team1BowlerList) {
		this.team1BowlerList = team1BowlerList;
	}

	public void setTeam2BowlerList(ArrayList<Bowler> team2BowlerList) {
		this.team2BowlerList = team2BowlerList;
	}

	public String[] getInputs() {
		return inputs;
	}

	public void setInputs(String[] inputs) {
		this.inputs = inputs;
	}

}
