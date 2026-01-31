package pl.edu.agh.hangman;

public class CheckLetters {
    private final String word;
    private char[] showingWord;
    private int gameStatus = 1;

    public CheckLetters(String word) {
        this.word = word;
        this.showingWord = new char[word.length()];
    }

    private void ContainsLetter(String word, char letter) {
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == letter) {
                showingWord[i] = letter;
            }
        }



    }

    public char[] getShowingWord() {
        return showingWord;
    }

    public int getGameStatus() {
        return gameStatus;
    }
}
