package hangman;

import java.util.Scanner;

public class Hangman {
    public static void main(String[] args) {
        //Declaring variables
        String targetWord, theGuess;
        String blankTargetWord[];
        int amountOfGuesses = 8;

        //Instantiating relevant Classes
        Scanner input = new Scanner(System.in);
        Checker check = new Checker();

        // Player one entering a word
        System.out.println("Player One, enter a word:");
        targetWord = input.next();
        check.setTargetWord(targetWord);

        //Printing the blanks
        blankTargetWord = new String[targetWord.length()];
        for(int i = 0; i < targetWord.length(); i++) {
            blankTargetWord[i] = "_";
        }
        for(String element: blankTargetWord){
            System.out.print(element);
        }

        // Prompting player two to enter a letter/word
        System.out.println("\nPlayer Two, you have " + amountOfGuesses + " guesses left. Enter a guess:");
        theGuess = input.next();
        check.setTheGuess(theGuess);

        //Checking if the letter/word is correct


//        int indexOfTheGuess = targetWord.indexOf(theGuess);
//        if(indexOfTheGuess != -1){
//            System.out.println("Letter exists " + targetWord.charAt(indexOfTheGuess) + indexOfTheGuess);
//        }else{
//            System.out.println("Letter doesn't exist");
//
//        }
    }
}
