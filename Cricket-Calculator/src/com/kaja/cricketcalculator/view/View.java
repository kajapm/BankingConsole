package com.kaja.cricketcalculator.view;

import java.util.Scanner;

import com.kaja.cricketcalculator.controller.InputOperations;

public class View {
	private InputOperations inputOperations;
	private Scanner scanner = new Scanner(System.in);

	public View() {
		inputOperations = new InputOperations(this);
	}

	public void init() {
		
		System.out.print("Enter Input :");
		inputOperations.getInput();
		inputOperations.addTeams();
		inputOperations.addTeam1Players();
		inputOperations.addTeam2Players();

		getScore();
	}
	
	public void showIncorrectInput()
	{
		System.out.println("\nIncorrect Input.!\n");
		init();
	}

	private void getScore() {
		inputOperations.addScoresForTeam1();
		inputOperations.printScoresOfTeam1();

	}

	public String getInputString() {
		return scanner.nextLine();
	}

}
