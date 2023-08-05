package org.trail_01;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int minNumber, maxNumber, numberOfPlayers, attempts, randomNumber, minAttempts = Integer.MAX_VALUE;
        String playerName, winnerName = "";

        System.out.println("Welcome to the Guess the Number Game!");

        // Input the range of the random number
        System.out.print("Enter the minimum number: ");
        minNumber = scanner.nextInt();

        System.out.print("Enter the maximum number: ");
        maxNumber = scanner.nextInt();

        // Validate the range of the random number
        if (minNumber >= maxNumber) {
            System.out.println("Invalid range! The minimum number must be less than the maximum number.");
            scanner.close();
            return;
        }

        // Input the number of players
        System.out.print("Enter the number of players (1 to 3): ");
        numberOfPlayers = scanner.nextInt();

        // Validate the number of players
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
