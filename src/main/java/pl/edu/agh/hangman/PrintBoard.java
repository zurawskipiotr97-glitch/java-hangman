package pl.edu.agh.hangman;

public class PrintBoard {
    public static void print(char[] guessedWord, int wrongGuesses) {
        // wypisanie szubienicy
        System.out.println(Hangman.HANGMANPICS[wrongGuesses]);
        System.out.println();

        // wypisanie aktualnego stanu słowa
        for (char c : guessedWord) {
            System.out.print(c + " ");
        }
        System.out.println();
    }
}


