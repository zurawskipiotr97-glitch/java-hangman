package pl.edu.agh.hangman;

public class CheckLetters {
    private final String word;
    private char[] showingWord;
    private int gameStatus = 1;

    public CheckLetters(String word) {
        this.word = word;
        this.showingWord = new char[word.length()];
    }

    public void containsLetter(char letter) {
        System.out.println(word);
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
}
