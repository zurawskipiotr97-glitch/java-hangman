package pl.edu.agh.hangman;

import java.io.IOException;

public class CheckLetters {
    Config k = Config.getInstance();
    LosujSlowo losujPathCase = k.getCase();

    private final String word;
    private char[] showingWord;
    private int gameStatus;

    public CheckLetters() throws IOException, InterruptedException {
        this.word = losujPathCase.losujSlowo();
        this.showingWord = new char[word.length()];
        this.gameStatus = 0;
    }

    public void containsLetter(char letter) {
        if (Character.isAlphabetic(letter) && word.contains(String.valueOf(letter))) {
            try {
                String upperCaseWord = word.toUpperCase();
                char upperCaseLetter = Character.toUpperCase(letter);
                boolean found = false;

                for (int i = 0; i < word.length(); i++) {
                    if (upperCaseWord.charAt(i) == upperCaseLetter) {
                        showingWord[i] = upperCaseLetter;
                        found = true;
                    }
                }
                if (!found) {
                    gameStatus++;
                }
            } catch (Exception e) {
                gameStatus++;
            }
        } else {
            gameStatus++;
        }
    }

    public char[] getShowingWord() {
        return showingWord;
    }

    public int getGameStatus() {
        return gameStatus;
    }

    public String getWord(){
        return word;
    }
}
