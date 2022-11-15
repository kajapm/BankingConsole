package model;

public class Bowler {
	private String name;
	private int ball;
	private byte wicket;
	private int strikeRate;
	private byte contribution;
	private int runs;

	public int getBall() {
		return ball;
	}

	public void setBall(int ball) {
		this.ball = ball;
	}

	public byte getWicket() {
		return wicket;
	}

	public void setWicket(byte wicket) {
		this.wicket = wicket;
	}

	public int getStrikeRate() {
		return strikeRate;
	}

	public void setStrikeRate(int strikeRate) {
		this.strikeRate = strikeRate;
	}

	public byte getContribution() {
		return contribution;
	}

	public void setContribution(byte contribution) {
		this.contribution = contribution;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRuns() {
		return runs;
	}

	public void setRuns(int runs) {
		this.runs = runs;
	}
}
