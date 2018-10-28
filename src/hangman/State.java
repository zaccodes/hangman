package hangman;

import java.util.ArrayList;

public class State {
    private static int tries, reducer;
    private static String targetWord, theGuess;
    private static StringBuffer blanks = new StringBuffer();
    private static ArrayList<Character> match = new ArrayList<>();
    static ArrayList<Character> noMatch = new ArrayList<>();

    State(){

    }
    State(int tries){
        this.tries = tries;
    }

    public static int getReducer() {
        return reducer;
    }

    public static void setReducer(int reducerAmount) {
        reducer = reducerAmount;
    }

    public static int getTries() {
        return tries;
    }

    public static void setTries(int amountOfTries) {
        tries = amountOfTries;
    }

    public static String getTargetWord() {
        return targetWord;
    }

    public static String getTheGuess() {
        return theGuess;
    }

    public static void setTargetWord(String theWord) {
        targetWord = theWord;
    }

    public static void setTheGuess(String guess) {
        theGuess = guess;
    }

    public static StringBuffer getBlanks() {
        return blanks;
    }

    public static void setBlanks(StringBuffer blanks) {
        State.blanks = blanks;
    }

    public static ArrayList<Character> getMatch() {
        return match;
    }

    public static ArrayList<Character> getNoMatch() {
        return noMatch;
    }

    public static void setMatch(ArrayList<Character> match) {
        State.match = match;
    }

    public static void setNoMatch(ArrayList<Character> noMatch) {
        State.noMatch = noMatch;
    }
}
