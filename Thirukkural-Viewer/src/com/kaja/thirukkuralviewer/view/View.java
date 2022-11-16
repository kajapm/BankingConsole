package com.kaja.thirukkuralviewer.view;

import com.kaja.thirukkuralviewer.controller.Operations;

import java.util.Scanner;

public class View {
    private Scanner scan = new Scanner(System.in);
    private Operations operations = new Operations();

    public void mainMenu() {
        System.out.println("");
        System.out.println("Thirukkural Viewer.!");
        System.out.println("");
        System.out.println("1.View all Thirukkural");
        System.out.println("2.View Thirukkural with Meaning");
        System.out.println("3.View Thirukkural by section");
        System.out.println("4.View Thirukkural by Category");
        System.out.println("5.Search by number");
        System.out.println("6.search by word");
        System.out.println("7.Exit");
        System.out.println("");
        System.out.print("Enter your option :");

        String option = scan.nextLine();
        if (option.equals("1")) {
            operations.printVerses(1, 1330);
            mainMenu();
        } else if (option.equals("2")) {
            printMeaningPage();
            mainMenu();
        } else if (option.equals("3")) {
            printBySectionPage();
            mainMenu();
        } else if (option.equals("4")) {
            printByCategoryPage();
            mainMenu();
        } else if (option.equals("5")) {
            searchByNumberPage();
            mainMenu();
        } else if (option.equals("6")) {
            System.out.println("");
            System.out.print("Enter your option :");
            String containingWord = scan.nextLine().toLowerCase();
            operations.searchByWord(containingWord);
            mainMenu();
        } else if (option.equals("7")) {
            System.out.println("");
            System.out.println("நன்றி வணக்கம் !");
        } else {
            System.out.println("");
            System.out.println("Input wrong.");
            mainMenu();
        }
    }

    private void printMeaningPage() {
        System.out.println("");
        System.out.println("1.Meanings of Mu.Varadharaja");
        System.out.println("2.Meanings of salamon papaya");
        System.out.println("3.Meanings of M.karunanidhi");
        System.out.println("");
        System.out.print("Enter your option :");
        String option = scan.nextLine();

        if (option.equals("1")) {
            operations.printVerseWithMeaning("mv");
            mainMenu();
        } else if (option.equals("2")) {
            operations.printVerseWithMeaning("sp");
            mainMenu();
        } else if (option.equals("3")) {
            operations.printVerseWithMeaning("mk");
            mainMenu();
        } else {
            System.out.println("");
            System.out.println("Input wrong.");
            mainMenu();
        }
    }

    private void printBySectionPage() {
        System.out.println("");
        System.out.println("1.Arathupaal");
        System.out.println("2.Porutpaal");
        System.out.println("3.Inbathupaal");
        System.out.println();
        System.out.print("Enter your option :");

        String option = scan.nextLine();
        if (option.equals("1")) {
            System.out.println("");
            System.out.println("Arathupaal :");
            operations.printVerses(1, 380);
        } else if (option.equals("2")) {
            System.out.println("");
            System.out.println("Porutpaal :");
            operations.printVerses(380, 1080);
        } else if (option.equals("3")) {
            System.out.println("");
            System.out.println("Inbathupaal :");
            operations.printVerses(1080, 1330);
        } else {
            System.out.println("");
            System.out.println("Input wrong.");
            printBySectionPage();
        }
    }

    private void printByCategoryPage() {
        System.out.println("");
        System.out.println("1.பாயிரவியல் (Prologue) ==> Arathupaal");
        System.out.println("2.இல்லறவியல் (Domestic Virtue) ==> Arathupaal");
        System.out.println("3.துறவறவியல் (Ascetic Virtue) ==> Arathupaal");
        System.out.println("4.ஊழியல் (Fate) ==> Arathupaal");
        System.out.println("5.அரசியல் (Royalty) ==> Porutpaal");
        System.out.println("6.அமைச்சியல் (Ministers of State) ==> Porutpaal");
        System.out.println("7.அரணியல் (The Essentials of a State) ==> Porutpaal");
        System.out.println("8.கூழியல் (Way of Making Wealth) ==> Porutpaal");
        System.out.println("9.படையில் (The Excellence of an Army) ==> Porutpaal");
        System.out.println("10.நட்பியல் (Friendship) ==> Porutpaal");
        System.out.println("11.குடியியல் (Miscellaneous) ==> Porutpaal");
        System.out.println("12.களவியல் (The Pre-marital love) ==> Inbathupaal");
        System.out.println("13.கற்பியல் (The Post-marital love) ==> Inbathupaal");
        System.out.println("");
        System.out.print("Enter your option :");
        String option = scan.nextLine();

        if (option.equals("1")) {
            System.out.println(".பாயிரவியல் (Prologue) :");
            operations.printVerses(1, 40);
        } else if (option.equals("2")) {
            System.out.println("இல்லறவியல் (Domestic Virtue) :");
            operations.printVerses(41, 240);
        } else if (option.equals("3")) {
            System.out.println("துறவறவியல் (Ascetic Virtue) :");
            operations.printVerses(241, 370);
        } else if (option.equals("4")) {
            System.out.println("ஊழியல் (Fate) :");
            operations.printVerses(371, 380);
        } else if (option.equals("5")) {
            System.out.println("அரசியல் (Royalty) :");
            operations.printVerses(381, 630);
        } else if (option.equals("6")) {
            System.out.println("அமைச்சியல் (Ministers of State) :");
            operations.printVerses(631, 730);
        } else if (option.equals("7")) {
            System.out.println("அரணியல் (The Essentials of a State) :");
            operations.printVerses(731, 750);
        } else if (option.equals("8")) {
            System.out.println("கூழியல் (Way of Making Wealth) :");
            operations.printVerses(751, 760);
        } else if (option.equals("9")) {
            System.out.println("படையில் (The Excellence of an Army) :");
            operations.printVerses(761, 780);
        } else if (option.equals("10")) {
            System.out.println("நட்பியல் (Friendship) :");
            operations.printVerses(781, 950);
        } else if (option.equals("11")) {
            System.out.println("குடியியல் (Miscellaneous) :");
            operations.printVerses(951, 1080);
        } else if (option.equals("12")) {
            System.out.println("களவியல் (The Pre-marital love) :");
            operations.printVerses(1081, 1150);
        } else if (option.equals("13")) {
            System.out.println("கற்பியல் (The Post-marital love) :");
            operations.printVerses(1151, 1330);
        } else {
            System.out.println("Input wrong.");
            printByCategoryPage();
        }

    }

    private void searchByNumberPage() {
        try{
            System.out.println("");
            System.out.print("Enter the number :");
            int verse = Integer.parseInt(scan.nextLine());
            operations.searchByNumber(verse);
        }
        catch(NumberFormatException e)
        {
            System.out.println("Input wrong");
            mainMenu();
        }
    }

}
