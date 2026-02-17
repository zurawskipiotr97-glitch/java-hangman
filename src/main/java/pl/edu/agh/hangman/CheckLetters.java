package pl.edu.agh.hangman;

import java.io.IOException;

public class CheckLetters {
    Config k;
    LosujSlowo losujPathCase;

    private final String word;
    private final char[] showingWord;
    private final char[] charWord;
    private int gameStatus;

    public CheckLetters(Config k) throws IOException, InterruptedException {
        this.k = k;
        this.losujPathCase = k.getCase();
        this.word = losujPathCase.losujSlowo();
        this.showingWord = new char[word.length()];
        this.charWord = word.toUpperCase().toCharArray();
        this.gameStatus = 0;
    }

    public void prepare() {
        for (int i = 0; i < word.length(); i++) {
            if (!Character.isLetter(word.charAt(i))) {
                showingWord[i] = word.charAt(i);
            }
        }
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

    public char[] getCharWord() {
        return charWord;
    }
}
