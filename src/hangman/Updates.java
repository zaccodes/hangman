package hangman;

import java.util.ArrayList;
import java.util.HashSet;

public class Updates {

    public static void createBlanks(String targetWord){
        StringBuffer blanks = new StringBuffer();
        for (int i = 0; i < targetWord.length(); i++)
            blanks.append("_");
        State.setBlanks(blanks);
    }

    public static void updateReducer(){
        ArrayList<Character> noMatch = new ArrayList<>();
          noMatch =  State.getNoMatch();
        // Change no match lists to a set to remove duplicates
        HashSet<Character> noDuplicates = new HashSet<>(noMatch);
        //Set the state reducer to the size of noDuplicates
        int reducer = noDuplicates.size();
        State.setReducer(reducer);
        //reset no match
        noMatch = new ArrayList<>();
        State.setNoMatch(noMatch);
    }

    public static void resetReducer() {
        int reset = 0;
        State.setReducer(reset);
    }

    public static void updateTries(){
        int tries = State.getTries();
        int reducer = State.getReducer();
        int difference = tries - reducer;
        State.setTries(difference);
    }

    public static void updateBlanks(){
        String targetword = State.getTargetWord();
        StringBuffer blanks = State.getBlanks();
        ArrayList<Character> match = State.getMatch();
        for(int j = 0; j < targetword.length(); j++) {
            for (int k = 0; k < match.size(); k++) {
                if (targetword.charAt(j) == match.get(k)) {
                    blanks.setCharAt(j, match.get(k));
                }
            }
        }
        State.setBlanks(blanks);
    }

    public static void updateMatches(){
        String targetWord = State.getTargetWord();
        String theGuess = State.getTheGuess();
        ArrayList<Character> noMatch = State.getNoMatch();
        ArrayList<Character> match = State.getMatch();

        for (int k = 0; k < theGuess.length(); k++) {
            if ( targetWord.contains(Character.toString(theGuess.charAt(k))) ) {
                match.add(theGuess.charAt(k));
            } else {
                noMatch.add(theGuess.charAt(k));
            }
        }

        State.setMatch(match);
        State.setNoMatch(noMatch);
    }

}
