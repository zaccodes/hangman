package hangman;

import java.util.ArrayList;

public class Misc {
    public static void promptPlayerOne(){
        System.out.println("Player One, enter a word:");
    }

    public static void promptPlayerTwo(int tries){
        System.out.println("Player Two, you have " + tries + " guesses left. Enter a guess:");
    }

    public static void duplicateGuess(String theGuess){
        System.out.println("You have already guessed '" + theGuess + "'");
    }

    public static void victoryPlayerOne(){
        String targetWord = State.getTargetWord();
        System.out.println("Game over. Player One wins! The word was: " + targetWord);
    }

    public static void victoryPlayerTwo(){
        System.out.println("Game over. Player Two wins!");

    }

    public static void printBlanks(){
        System.out.println(State.getBlanks());
    }


    public static void checkBlanks(){
        StringBuffer blanks = State.getBlanks();
        for (int k = 0; k < blanks.length(); k++) {
            if (blanks.indexOf("_") == -1) {
                Misc.victoryPlayerTwo();
                State.setTries(0);
                break;
            }
        }
    }



}
