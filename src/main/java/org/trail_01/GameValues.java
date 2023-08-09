package org.trail_01;

import java.util.*;

public class GameValues {
    private int minNumber, maxNumber, numberOfPlayers, attempts, randomNumber, minAttempts = Integer.MAX_VALUE;
    private String playerName, winnerName;
    InputChecker inputChecker = new InputChecker();

    public int getMinNumber() {
        return minNumber;
    }
    public int getMaxNumber(){
        return maxNumber;
    }

    public int getRandomNumber() {
        return randomNumber;
    }

    public int getMinAttempts() {
        return minAttempts;
    }

    public String getWinnerName() {
        return winnerName;
    }

    public void setMinNumber(int minNumber) {
        this.minNumber = minNumber;
    }

    public void setMaxNumber(int maxNumber) {
        this.maxNumber = maxNumber;
    }

    public void setNumberOfPlayers(int numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
    }
    public void setRandomNumber(){
        Random random = new Random();
        this.randomNumber = random.nextInt(getMaxNumber() - getMinNumber()) + getMinNumber();
    }
    public void setPlayerName(int plyno) {
        this.playerName = inputChecker.inputString("Player " + plyno + ", enter your name: ");
    }

    public void setWinnerName(String winnerName) {
        this.winnerName = winnerName;
    }

    public void setMinAttempts(int minAttempts) {
        this.minAttempts = minAttempts;
    }

    public boolean numberchecker() {
        boolean return_value = true;
        if (this.minNumber >= this.maxNumber){
            System.out.println("Invalid range! The minimum number must be less than the maximum number.");
            return_value = false;
        }
        return return_value;
    }
    public void minnmaxinput(){
        setMinNumber(inputChecker.inputInt("Enter the minimum number: "));
        setMaxNumber(inputChecker.inputInt("Enter the maximum number: "));
    }
    public boolean intherang(){
        boolean return_value = true;
        if (this.numberOfPlayers <= 0 || this.numberOfPlayers > 3) {
            System.out.println("Invalid number of players! Please enter a value between 1 and 3.");
            return_value = false;
        }
        return return_value;
    }

    public void randomloop() {
        for (int i = 1; i <= this.numberOfPlayers; i ++) {
            this.attempts = 0;
            boolean keepdoing = true;
            setRandomNumber();
            setPlayerName(i);
            System.out.println("Hi, " + this.playerName + "! I have picked a number between " + this.minNumber + " and " + this.maxNumber + ". Can you guess it?");
            do {
                int guess = inputChecker.inputInt("Enter your guess: ");
                this.attempts++;
                keepdoing = answerchecker(guess);
            } while (keepdoing);
        }
    }

    public boolean answerchecker(int guessnumber) {
        boolean keepdoing = true;
        if(guessnumber == this.getRandomNumber()) {
            keepdoing = false;
            System.out.println("Congratulations, " + this.playerName + "! You guessed the correct number " + this.randomNumber + " in " + this.attempts + " attempts!");
            if(this.attempts < this.minAttempts){
                this.setMinAttempts(this.attempts);
                this.setWinnerName(this.playerName);
            }
        } else if (guessnumber < this.getRandomNumber()){
            System.out.println("Try again, " + this.playerName + "! The number is higher.");
        } else {
            System.out.println("Try again, " + this.playerName + "! The number is lower.");
        }
        return keepdoing;
    }
}
