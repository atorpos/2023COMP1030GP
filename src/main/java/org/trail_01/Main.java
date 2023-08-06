package org.trail_01;
import java.util.*;
import java.io.*;
import java.net.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int minNumber, maxNumber, numberOfPlayers, attempts, randomNumber, minAttempts = Integer.MAX_VALUE;
        String playerName, winnerName = "";
//        ConnectToInternet cTi = new ConnectToInternet();
//        cTi.numebreffect();
        System.out.println("Welcome to the Guess the Number Game!");

        // Input the range of the random number
        while (true) {
            try {
                System.out.print("Enter the minimum number: ");
                minNumber = scanner.nextInt();
                break;
            } catch (Exception e) {
                scanner.nextLine(); // Consume the invalid input
                System.out.println("Invalid input. Please enter an integer.");
            }
        }

        while (true) {
            try {
                System.out.print("Enter the maximum number: ");
                maxNumber = scanner.nextInt();
                break;
            } catch (Exception e) {
                scanner.nextLine(); // Consume the invalid input
                System.out.println("Invalid input. Please enter an integer.");
            }
        }

        // Validate the range of the random number
        if (minNumber >= maxNumber) {
            System.out.println("Invalid range! The minimum number must be less than the maximum number.");
            scanner.close();
            return;
        }

        // Input the number of players
        while (true) {
            try {
                System.out.print("Enter the number of players (1 to 3): ");
                numberOfPlayers = scanner.nextInt();
                break;
            } catch (Exception e) {
                scanner.nextLine(); // Consume the invalid input
                System.out.println("Invalid input. Please enter an integer.");
            }
        }

        // Validate the number of players
//        boolean numberinRange = true;
//        while (numberinRange) {
//            if (numberOfPlayers <= 0 || numberOfPlayers > 3) {
//                numberinRange = true;
//            } else {
//                numberinRange = false;
//            }
//        }
        if (numberOfPlayers <= 0 || numberOfPlayers > 3) {
            System.out.println("Invalid number of players! Please enter a value between 1 and 3.");
            scanner.close();
            return;
        }

        // Loop for each player
        for (int player = 1; player <= numberOfPlayers; player++) {
            attempts = 0;
            // Generate a new random number for each player
            randomNumber = random.nextInt(maxNumber - minNumber + 1) + minNumber;
            scanner.nextLine(); // Clear the input buffer

            // Input the name of the current player
            System.out.print("Player " + player + ", enter your name: ");
            playerName = scanner.nextLine();

            // Start the game for the current player
            System.out.println("Hi, " + playerName + "! I have picked a number between " + minNumber + " and " + maxNumber + ". Can you guess it?");
            System.out.println(randomNumber);
            // Guessing loop for the current player
            while (true) {
                System.out.print("Enter your guess: ");
                int guess = scanner.nextInt();
                attempts++;

                // Check if the guess is correct
                if (guess == randomNumber) {
                    System.out.println("Congratulations, " + playerName + "! You guessed the correct number " + randomNumber + " in " + attempts + " attempts!");

                    // Update winner details if this player has the lowest attempts
                    if (attempts < minAttempts) {
                        minAttempts = attempts;
                        winnerName = playerName;
                    }
                    break;
                } else if (guess < randomNumber) {
                    System.out.println("Try again, " + playerName + "! The number is higher.");
                } else {
                    System.out.println("Try again, " + playerName + "! The number is lower.");
                }
            }
        }

        // Display the winner
        if (!winnerName.isEmpty()) {
            System.out.println("Congratulations, " + winnerName + "! You are the winner with the lowest number of attempts: " + minAttempts + " attempts.");
        }

        scanner.close();
    }
}
