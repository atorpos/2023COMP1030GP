package org.trail_01;

import java.util.*;

public class GameValues {
    private int minNumber, maxNumber, numberOfPlayers, attempts, randomNumber, minAttempts = Integer.MAX_VALUE;
    private String playerName, winnerName;

    private String[] playersname;
    private int[] playertrial;

    public void SetArraySize(int initSize) {
        playersname = new String[initSize];
        playertrial = new int[initSize];
//        arraysize = 0;
    }
    public void listarray() {
        System.out.printf("___________________________\n");
        for (int i =0; i < playersname.length; i++) {
            System.out.printf("| %10s | %10s |\n", this.playersname[i], this.playertrial[i]);
        }
        System.out.printf("___________________________\n");
    }

    public void gameResultCheck(){
        int firstvalue = playertrial[0];
        int matchedvalue = 0;
        int winnerlocation = 0;
        boolean isMatch = false;
        StringBuilder matchplayers = new StringBuilder(new String(""));

        for (int i = 1; i < playertrial.length; i++) {
            if(playertrial[i] < firstvalue) {
                firstvalue = playertrial[i];
                winnerlocation = i;
            }
        }
        matchplayers.append(playersname[winnerlocation]);
        for (int j = 0; j< playertrial.length; j++) {
            if (playertrial[j] == firstvalue && j != winnerlocation){
                    matchplayers.append(", ").append(playersname[j]);
                    isMatch = true;
            }
        }
        if (isMatch) {
            System.out.printf("We have tie! Winners are %s ", matchplayers);
        } else {
            System.out.printf("Congratulations %s! You are the winner with the lowest number of attempts: %s attempts.", this.playersname[winnerlocation], this.playertrial[winnerlocation]);
        }

    }

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
        SetArraySize(this.numberOfPlayers);
        for (int i = 1; i <= this.numberOfPlayers; i ++) {
            this.attempts = 0;
            boolean keepdoing = true;
            setRandomNumber();
            setPlayerName(i);
            this.playersname[i-1] = this.playerName;
            System.out.println("Hi, " + this.playerName + "! I have picked a number between " + this.minNumber + " and " + this.maxNumber + ". Can you guess it?");
            do {
                int guess = inputChecker.inputInt("Enter your guess: ");
                this.attempts++;
                keepdoing = answerchecker(guess);
            } while (keepdoing);
            this.playertrial[i-1] = this.attempts;
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
