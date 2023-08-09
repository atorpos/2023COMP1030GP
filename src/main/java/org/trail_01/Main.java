package org.trail_01;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GameValues gamevalues = new GameValues();
        InputChecker inputChecker = new InputChecker();

        System.out.println("Welcome to the Guess the Number Game!");

        // Input the range of the random number
        gamevalues.minnmaxinput();

        // Validate the range of the random number
        if(!gamevalues.numberchecker()) {
            gamevalues.minnmaxinput();
        }

        // Input the number of players
        gamevalues.setNumberOfPlayers(inputChecker.inputInt("Enter the number of players (1 to 3): ")); ;

        // Validate the number of players
        if (!gamevalues.intherang()) {
            gamevalues.setNumberOfPlayers(inputChecker.inputInt("Enter the number of players (1 to 3): "));
        }
        //Loop for each player
        gamevalues.randomloop();

        // Display the winner
        if (!gamevalues.getWinnerName().isEmpty()) {
            System.out.println("Congratulations, " + gamevalues.getWinnerName() + "! You are the winner with the lowest number of attempts: " + gamevalues.getMinAttempts() + " attempts.");
        }

        scanner.close();
    }
}
