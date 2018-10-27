package hangman;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.lang.*;

public class Hangman {
    public static void main(String[] args) {
        //Instantiating Scanner and checker
        Scanner input = new Scanner(System.in);
        Checker checker = new Checker();

        String targetWord; // This is the word Player one choose that Player Two has to guess
        StringBuffer blankWord = new StringBuffer(); //This is going to be my underscores
        ArrayList<String> guessed = new ArrayList<>();
        ArrayList<Character> match = new ArrayList<>();
        ArrayList<Character> noMatch = new ArrayList<>();
        HashSet<Character> noDuplicates = new HashSet<>();
        String theGuess; // This is the letter or word that Player two guesses

        int tries = 8; // The amount of guesses the player has;

        //Prompting Player One for their proposed word
        System.out.println("Player One, enter a word:");
        targetWord = input.next();
        //End of Prompting

        //Printing the blank word, to show amount of letters of target word
        for (int i = 0; i < targetWord.length(); i++)
            blankWord.append("_");
        System.out.println(blankWord);
        //End of Printing Blanks
        GAME:
        while (tries > 0) {
            //Prompting Player Two to guess a letter/word
            System.out.println("Player Two, you have " + tries + " guesses left. Enter a guess:");
            theGuess = input.next();
            //End of Prompting for the guess
            if (guessed.contains(theGuess)) {
                System.out.println("You have already guessed '" + theGuess + "'");
            } else {
                //Add theGuess to the Guessed list
                guessed.add(theGuess);
                //Not done yet can't comment exactly what it does //Have to refactor to check if its more than one letter for whole word
                if (targetWord.equals(theGuess)) {
                    System.out.println("Game over. Player Two wins!");
                    break GAME;
                } else {
                    // This for-loop adds all letter that match to a list and those that don't to another list Whats needed ** theGuess, targetword
                    for (int k = 0; k < theGuess.length(); k++) {
                        if ( targetWord.contains(Character.toString(theGuess.charAt(k))) ) {
                            match.add(theGuess.charAt(k));
                        } else {
                            noMatch.add(theGuess.charAt(k));
                        }
                    }

                    // Add all letters that match to the correct position What's Needed ** targetWord, match
                    for(int j = 0; j < targetWord.length(); j++) {
                        for (int k = 0; k < match.size(); k++) {
                            if (targetWord.charAt(j) == match.get(k)) {
                                blankWord.setCharAt(j, match.get(k));
                            }
                        }
                    }

                    // Change no match lists to a set and back to a list to remove duplicates
                    noDuplicates.addAll(noMatch);

                    tries = tries - noDuplicates.size();

                }


                // Then print the blank word with correct letter filled in
                System.out.println(blankWord);
                for (int k = 0; k < blankWord.length(); k++) {
                    if (blankWord.indexOf("_") == -1) {
                        System.out.println("Game over. Player Two wins!");
                        break GAME;
                    }
                }
                if (tries < 0) {
                    System.out.println("Game over. Player One wins! The word was: " + targetWord);
                }
            }

        }
    }
}
