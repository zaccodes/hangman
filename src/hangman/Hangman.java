package hangman;

import java.util.ArrayList;
import java.util.Scanner;
import java.lang.*;

public class Hangman {

    public static Scanner input;

    public static void main(String[] args) {
        //Instantiating Scanner, State, Updates
        input = new Scanner(System.in);
        State state = new State(8);

        //Prompting Player One for their proposed word
        promptPlayerOne();

        //The call to start the Game
        start();
    }

    public static void promptPlayerOne(){
        //Prompting Player One for their proposed word
        Misc.promptPlayerOne();
        String targetWord = input.next();
        State.setTargetWord(targetWord); // Storing targetword in state


        //Printing the blank word, to show amount of letters of target word
        Updates.createBlanks(targetWord);
        Misc.printBlanks();
    }

    public static void start(){

        //Declaring names for my variables and lists
        ArrayList<String> guessed = new ArrayList<>();

        GAME: // The start of the "Game"
        while (State.getTries() > 0) {
            //Prompting Player Two to guess a letter/word
            Misc.promptPlayerTwo(State.getTries());
            String theGuess = input.next();
            State.setTheGuess(theGuess);


            if (guessed.contains(theGuess)) {
                Misc.duplicateGuess(theGuess);
                Misc.printBlanks();
            } else {
                //Add theGuess to the guessed list
                guessed.add(theGuess);
                //Not done yet can't comment exactly what it does //Have to refactor to check if its more than one letter for whole word
                if (State.getTargetWord().equals(theGuess)) {
                    Misc.victoryPlayerTwo();
                    break GAME;
                } else {
                    Updates.updateMatches();

                    Updates.updateBlanks();

                    Updates.updateReducer();

                    Updates.updateTries();

                    Updates.resetReducer();

                }
                // Then print the blank word with correct letter(s) filled in
                Misc.printBlanks();

                //If Player Two is out of tries. Print an informative message and end game.
                if (State.getTries() <= 0) {
                    Misc.victoryPlayerOne();
                }

                Misc.checkBlanks();

            }
        }
    }
}
