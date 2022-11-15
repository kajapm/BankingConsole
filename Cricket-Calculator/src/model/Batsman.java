package model;

public class Batsman {
	private String name; 
	private int score;
	private byte ball;
	private int strikeRate;
	private byte contribution;

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public byte getBall() {
		return ball;
	}

	public void setBall(byte ball) {
		this.ball = ball;
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
}
