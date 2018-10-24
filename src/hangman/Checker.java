package hangman;

public class Checker {
    private String theGuess, targetWord;

    public String getTargetWord() {
        return targetWord;
    }

    public String getTheGuess() {
        return theGuess;
    }

    public void setTargetWord(String targetWord) {
        this.targetWord = targetWord;
    }

    public void setTheGuess(String theGuess) {
        this.theGuess = theGuess;
    }

    public void checking(){
        char converted[] = converter(targetWord);
        // We also have theGuess available

        //finding the index of theGuess


    }

    public char[] converter(String targetWord){
        int amountOfChars = targetWord.length();
        char wordArray[] = new char[amountOfChars];
        for(int i =0; i < targetWord.length(); i++){
            wordArray[i] = targetWord.charAt(i);
        }
        return wordArray;
    }

    public void returnIndex(int n){

    }


}
