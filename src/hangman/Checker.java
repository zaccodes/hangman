package hangman;

import java.util.ArrayList;

public class Checker {
    public int checker(String targetWord, String theGuess, ArrayList<String> guessed){
        int amountToMinus = 0;

            for(int i = 0; i < theGuess.length(); i++){
                if(!guessed.contains(theGuess.charAt(i))) {
                    for (int j = 0; j < targetWord.length(); j++) {
                        if (!targetWord.contains(Character.toString(theGuess.charAt(i)))) {
                            amountToMinus++;
                            guessed.add(String.valueOf(theGuess.charAt(i)));
                        }
                    }
                }
            }

        return amountToMinus;
    }
}
