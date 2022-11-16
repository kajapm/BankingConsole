package com.kaja.cricketcalculator.model;

public class TeamScore {
	private String name;
	private int inningExtras;
	private int teamScore;
	private int wickets;

	public int getInningExtras() {
		return inningExtras;
	}

	public void setInningExtras(int inningExtras) {
		this.inningExtras = inningExtras;
	}

	public int getTeamScore() {
		return teamScore;
	}

	public void setTeamScore(int teamScore) {
		this.teamScore = teamScore;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getWickets() {
		return wickets;
	}

	public void setWickets(int wickets) {
		this.wickets = wickets;
	}
}
