package controller;

import java.util.ArrayList;
import java.util.HashMap;
import model.Batsman;
import model.Bowler;
import model.TeamScore;
import repositary.CricketDatabase;
import view.View;

public class InputOperations {
	View view;
	CricketDatabase cricketDatabase;

	public InputOperations(View view) {
		this.view = view;
		cricketDatabase = CricketDatabase.getInstance();
	}

	public void getInput() {
		String input = view.getInputString();
		String[] inputArray = input.split(" ");
		cricketDatabase.setInputs(inputArray);
	}

	public void addTeams() {
		HashMap<String, TeamScore> teams = new HashMap<String, TeamScore>();
		String[] teamFromInput = cricketDatabase.getInputs()[0].split(",");
		teams.put("team1", new TeamScore());
		teams.put("team2", new TeamScore());

		teams.get("team1").setName(teamFromInput[0]);
		teams.get("team2").setName(teamFromInput[1]);
		cricketDatabase.setTeams(teams);

	}

	public void addTeam1Players() {

		try {
			ArrayList<Batsman> team1Batsmans = new ArrayList<Batsman>();
			ArrayList<Bowler> team1Bowlers = new ArrayList<Bowler>();
			String[] players = cricketDatabase.getInputs()[1].split(",");
			for (int i = 0; i < 3; i++) {
				Batsman batsman = new Batsman();
				batsman.setName(players[i]);
				team1Batsmans.add(batsman);
			}
			for (int i = 3; i < 5; i++) {
				Bowler bowler = new Bowler();
				bowler.setName(players[i]);
				team1Bowlers.add(bowler);
			}
			cricketDatabase.setTeam1BatsmanList(team1Batsmans);
			cricketDatabase.setTeam1BowlerList(team1Bowlers);
		} catch (IndexOutOfBoundsException e) {
			view.showIncorrectInput();
		}

	}

	public void addTeam2Players() {

		try {
			ArrayList<Batsman> team2Batsmans = new ArrayList<Batsman>();
			ArrayList<Bowler> team2Bowlers = new ArrayList<Bowler>();
			String[] players = cricketDatabase.getInputs()[2].split(",");
			for (int i = 0; i < 3; i++) {
				Batsman batsman = new Batsman();
				batsman.setName(players[i]);
				team2Batsmans.add(batsman);
			}
			for (int i = 3; i < 5; i++) {
				Bowler bowler = new Bowler();
				bowler.setName(players[i]);
				team2Bowlers.add(bowler);
			}
			cricketDatabase.setTeam2BatsmanList(team2Batsmans);
			cricketDatabase.setTeam2BowlerList(team2Bowlers);
		} catch (IndexOutOfBoundsException e) {
			view.showIncorrectInput();
		}

	}

	public void addScoresForTeam1() {

		try {
			ArrayList<Batsman> team1BatsmanList = cricketDatabase.getTeam1BatsmanList();
			ArrayList<Bowler> team2BowlerList = cricketDatabase.getTeam2BowlerList();
			HashMap<String, TeamScore> team = cricketDatabase.getTeams();
			String[] inputArray = cricketDatabase.getInputs();
			int secondInningIndex = 8;
			byte striker = 0;
			byte nonStriker = 1;
			byte wickets = 0;
			byte bowler1 = 0;
			byte bowler2 = 1;

			for (int i = 3; i < inputArray.length; i++) {
				if (wickets < 2) {
					String[] over = inputArray[i].split(",");
					for (int j = 0; j < over.length; j++) {
						Batsman batsman = team1BatsmanList.get(striker);
						Bowler bowler = team2BowlerList.get(bowler1);

						if (wickets < 2) {
							String score = over[j];
							if (score.equals("0")) {
								bowler.setBall(bowler.getBall() + 1);
								batsman.setBall((byte) (batsman.getBall() + 1));
							} else if (score.equals("1")) {
								batsman.setScore(batsman.getScore() + 1);
								bowler.setBall(bowler.getBall() + 1);
								bowler.setRuns(bowler.getRuns() + 1);
								batsman.setBall((byte) (batsman.getBall() + 1));
								team.get("team1").setTeamScore(team.get("team1").getTeamScore() + 1);
								byte temp = nonStriker;
								nonStriker = striker;
								striker = temp;
							} else if (score.equals("2")) {
								batsman.setScore(batsman.getScore() + 2);
								bowler.setBall(bowler.getBall() + 1);
								batsman.setBall((byte) (batsman.getBall() + 1));
								bowler.setRuns(bowler.getRuns() + 2);
								team.get("team1").setTeamScore(team.get("team1").getTeamScore() + 2);
							} else if (score.equals("4")) {
								batsman.setScore(batsman.getScore() + 4);
								bowler.setBall(bowler.getBall() + 1);
								batsman.setBall((byte) (batsman.getBall() + 1));
								bowler.setRuns(bowler.getRuns() + 4);
								team.get("team1").setTeamScore(team.get("team1").getTeamScore() + 4);
							} else if (score.equals("6")) {
								batsman.setScore(batsman.getScore() + 6);
								bowler.setBall(bowler.getBall() + 1);
								batsman.setBall((byte) (batsman.getBall() + 1));
								bowler.setRuns(bowler.getRuns() + 6);
								team.get("team1").setTeamScore(team.get("team1").getTeamScore() + 6);
							} else if (score.equals("w")) {
								bowler.setBall(bowler.getBall() + 1);
								batsman.setBall((byte) (batsman.getBall() + 1));
								bowler.setWicket((byte) (bowler.getWicket() + 1));
								team.get("team1").setWickets(team.get("team1").getWickets() + 1);
								wickets++;
								striker = 2;
							} else {
								int freeInningScore = Integer.parseInt(String.valueOf(score.charAt(0)));
								batsman.setBall((byte) (batsman.getBall() + 1));
								team.get("team1")
										.setTeamScore(team.get("team1").getTeamScore() + (freeInningScore + 1));
								team.get("team1").setInningExtras(team.get("team1").getInningExtras() + 1);
								bowler.setBall(bowler.getBall() + 1);
							}
						} else {
							secondInningIndex = i;
							break;
						}
					}
					byte temp = nonStriker;
					nonStriker = striker;
					striker = temp;

					byte tempBowler = bowler1;
					bowler1 = bowler2;
					bowler2 = tempBowler;

				} else {
					secondInningIndex = i;
					break;
				}

			}

			cricketDatabase.setTeam1BatsmanList(team1BatsmanList);
			cricketDatabase.setTeam2BowlerList(team2BowlerList);
			cricketDatabase.setTeams(team);
			addScoresForTeam2(secondInningIndex);
		} catch (IndexOutOfBoundsException  | NumberFormatException e) {
			view.showIncorrectInput();
		}

	}

	public void addScoresForTeam2(int index) {

		try {
			ArrayList<Batsman> team2BatsmanList = cricketDatabase.getTeam2BatsmanList();
			ArrayList<Bowler> team1BowlerList = cricketDatabase.getTeam1BowlerList();
			HashMap<String, TeamScore> team = cricketDatabase.getTeams();
			String[] inputArray = cricketDatabase.getInputs();
			byte striker = 0;
			byte nonStriker = 1;
			byte wickets = 0;
			byte bowler1 = 0;
			byte bowler2 = 1;

			for (int i = index; i < inputArray.length; i++) {
				if (wickets < 2 && team.get("team2").getTeamScore() < team.get("team1").getTeamScore()) {
					String[] over = inputArray[i].split(",");
					for (int j = 0; j < over.length; j++) {
						Batsman batsman = team2BatsmanList.get(striker);
						Bowler bowler = team1BowlerList.get(bowler1);

						if (wickets < 2 && team.get("team2").getTeamScore() < team.get("team1").getTeamScore()) {
							String score = over[j];
							if (score.equals("0")) {
								bowler.setBall(bowler.getBall() + 1);
								batsman.setBall((byte) (batsman.getBall() + 1));
							} else if (score.equals("1")) {
								batsman.setScore(batsman.getScore() + 1);
								batsman.setBall((byte) (batsman.getBall() + 1));
								bowler.setBall(bowler.getBall() + 1);
								bowler.setRuns(bowler.getRuns() + 1);
								team.get("team2").setTeamScore(team.get("team2").getTeamScore() + 1);
								byte temp = nonStriker;
								nonStriker = striker;
								striker = temp;
							} else if (score.equals("2")) {
								batsman.setScore(batsman.getScore() + 2);
								batsman.setBall((byte) (batsman.getBall() + 1));
								bowler.setBall(bowler.getBall() + 1);
								bowler.setRuns(bowler.getRuns() + 2);
								team.get("team2").setTeamScore(team.get("team2").getTeamScore() + 2);
							} else if (score.equals("4")) {
								batsman.setScore(batsman.getScore() + 4);
								batsman.setBall((byte) (batsman.getBall() + 1));
								bowler.setBall(bowler.getBall() + 1);
								bowler.setRuns(bowler.getRuns() + 4);
								team.get("team2").setTeamScore(team.get("team2").getTeamScore() + 4);
							} else if (score.equals("6")) {
								batsman.setScore(batsman.getScore() + 6);
								batsman.setBall((byte) (batsman.getBall() + 1));
								bowler.setBall(bowler.getBall() + 1);
								bowler.setRuns(bowler.getRuns() + 6);
								team.get("team2").setTeamScore(team.get("team2").getTeamScore() + 6);
							} else if (score.equals("w")) {

								bowler.setBall(bowler.getBall() + 1);
								batsman.setBall((byte) (batsman.getBall() + 1));
								team.get("team2").setWickets(team.get("team2").getWickets() + 1);
								bowler.setWicket((byte) (bowler.getWicket() + 1));
								wickets++;
								striker = 2;
							} else {
								int freeInningScore = Integer.parseInt(String.valueOf(score.charAt(0)));
								batsman.setBall((byte) (batsman.getBall() + 1));
								team.get("team2")
										.setTeamScore(team.get("team2").getTeamScore() + (freeInningScore + 1));
								bowler.setRuns(bowler.getRuns() + freeInningScore + 1);
								team.get("team2").setInningExtras(team.get("team2").getInningExtras() + 1);
								bowler.setBall(bowler.getBall() + 1);
							}
						} else {
							break;
						}
					}
					byte temp = nonStriker;
					nonStriker = striker;
					striker = temp;

					byte tempBowler = bowler1;
					bowler1 = bowler2;
					bowler2 = tempBowler;

				} else {
					break;
				}

			}
			cricketDatabase.setTeam2BatsmanList(team2BatsmanList);
			cricketDatabase.setTeam1BowlerList(team1BowlerList);
			cricketDatabase.setTeams(team);
		} catch (IndexOutOfBoundsException  | NumberFormatException  e) {
			view.showIncorrectInput();
		}

	}

	public void printScoresOfTeam1() {
		HashMap<String, TeamScore> team = cricketDatabase.getTeams();
		ArrayList<Batsman> batmansOfTeam1 = cricketDatabase.getTeam1BatsmanList();
		ArrayList<Bowler> bowlersOfTeam1 = cricketDatabase.getTeam1BowlerList();

		System.out.println("Team 1 score :");
		System.out.println(team.get("team1").getName() + " - " + team.get("team1").getTeamScore() + "/"
				+ team.get("team1").getWickets());
		System.out.println();
		System.out.println("Batting :");
		for (int i = 0; i < batmansOfTeam1.size(); i++) {
			Batsman batsman = batmansOfTeam1.get(i);
			System.out.println(
					batsman.getName() + " - " + batsman.getScore() + " runs (" + batsman.getBall() + " balls)");
		}
		System.out.println("Innings Extra :" + team.get("team1").getInningExtras());
		System.out.println("");
		for (int i = 0; i < bowlersOfTeam1.size(); i++) {
			Bowler bowler = bowlersOfTeam1.get(i);
			System.out.println(bowler.getName() + " - " + (bowler.getBall() / 6) + "." + (bowler.getBall() % 6)
					+ " overs  " + bowler.getRuns() + "/" + bowler.getWicket());
		}
		System.out.println("");

		System.out.println("Player Stats :");
		for (int i = 0; i < batmansOfTeam1.size(); i++) {
			Batsman batsman = batmansOfTeam1.get(i);
			System.out.print(batsman.getName() + " - " + batsman.getScore() + "(" + batsman.getBall() + ") SR "
					+ Math.round(((double) batsman.getScore() / (double) batsman.getBall()) * 100) + "%");
			System.out.println(
					"- C " + Math.round(((double) batsman.getScore() / (double) team.get("team1").getTeamScore()) * 100)
							+ "% (" + batsman.getScore() + "/" + team.get("team1").getTeamScore() + ")");
		}
		for (int i = 0; i < bowlersOfTeam1.size(); i++) {
			Bowler bowler = bowlersOfTeam1.get(i);
			System.out.println(bowler.getName() + " -" + bowler.getWicket() + "(2) C "
					+ ((double) (bowler.getWicket()) / 2) * 100 + "%");
		}
		printScoresOfTeam2();
	}

	private void printScoresOfTeam2() {
		HashMap<String, TeamScore> team = cricketDatabase.getTeams();
		ArrayList<Batsman> batmansOfTeam2 = cricketDatabase.getTeam2BatsmanList();
		ArrayList<Bowler> bowlersOfTeam2 = cricketDatabase.getTeam2BowlerList();
		System.out.println("\n");
		System.out.println("Team 2 score :");
		System.out.println(team.get("team2").getName() + " - " + team.get("team2").getTeamScore() + "/"
				+ team.get("team2").getWickets());
		System.out.println();
		System.out.println("Batting :");
		for (int i = 0; i < batmansOfTeam2.size(); i++) {
			Batsman batsman = batmansOfTeam2.get(i);
			System.out.println(
					batsman.getName() + " - " + batsman.getScore() + " runs (" + batsman.getBall() + " balls)");
		}
		System.out.println("Innings Extra :" + team.get("team2").getInningExtras());
		System.out.println("");
		for (int i = 0; i < bowlersOfTeam2.size(); i++) {
			Bowler bowler = bowlersOfTeam2.get(i);
			System.out.println(bowler.getName() + " - " + (bowler.getBall() / 6) + "." + (bowler.getBall() % 6)
					+ " overs  " + bowler.getRuns() + "/" + bowler.getWicket());
		}
		System.out.println("");

		System.out.println("Player Stats :");
		for (int i = 0; i < batmansOfTeam2.size(); i++) {
			Batsman batsman = batmansOfTeam2.get(i);
			System.out.print(batsman.getName() + " - " + batsman.getScore() + "(" + batsman.getBall() + ") SR "
					+ Math.round(((double) batsman.getScore() / (double) batsman.getBall()) * 100));
			System.out.println(
					"- c " + Math.round(((double) batsman.getScore() / (double) team.get("team2").getTeamScore()) * 100)
							+ " (" + batsman.getScore() + "/" + team.get("team2").getTeamScore() + ")");
		}

		for (int i = 0; i < bowlersOfTeam2.size(); i++) {
			Bowler bowler = bowlersOfTeam2.get(i);
			System.out.println(bowler.getName() + " - " + bowler.getWicket() + "(2) C "
					+ ((double) (bowler.getWicket()) / 2) * 100 + "%");
		}
	}
}
