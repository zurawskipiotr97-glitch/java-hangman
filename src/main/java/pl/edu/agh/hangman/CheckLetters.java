package pl.edu.agh.hangman;

import java.io.IOException;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class CheckLetters {
    Config k;
    LosujSlowo losujPathCase;

    private final String word;
    private final char[] showingWord;
    private final char[] charWord;
    private int gameStatus;
    private final Set<Character> wrongLetters = new TreeSet<>();

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
        if (!Character.isLetter(letter)) {
            gameStatus++;
            return; // nie ma sensu dodawać np. spacji do złych liter
        }

        char upperCaseLetter = Character.toUpperCase(letter);
        boolean found = false;

        for (int i = 0; i < charWord.length; i++) {
            if (charWord[i] == upperCaseLetter) {
                showingWord[i] = upperCaseLetter;
                found = true;
            }
        }

        if (!found) {
            if (wrongLetters.add(upperCaseLetter)) {
                gameStatus++;
            }
        }
    }

    public String getWrongLetters() {
        return wrongLetters.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
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

    public String getWord() {
        return word;
    }
}
