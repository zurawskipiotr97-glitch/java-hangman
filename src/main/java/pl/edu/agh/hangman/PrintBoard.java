package pl.edu.agh.hangman;

import java.sql.SQLOutput;

public class PrintBoard {
    Config k = Config.getInstance();
    String[] tablica;
    int stanGry;
    char[] showWord;
    int wynik;

    public PrintBoard(CheckLetters gra) {
        this.stanGry = gra.getGameStatus();
        this.tablica = k.getTable();;
        this.showWord = new char[gra.getShowingWord().length];
    }

    public void printBoard(CheckLetters gra) {
        if (tablica.length != gra.getGameStatus()) {
            System.out.println();
            System.out.println(tablica[gra.getGameStatus()]);
            showWord = changeWord(gra.getShowingWord());
            System.out.println(showWord);
            System.out.println(gra.getWord());
        } else {
            switch(wynik) {
                case 0 -> {
                    {
                        System.out.println("LOOSER");
                    }
                    return;
                }

                case 1 -> {
                    System.out.println("WINNER");
                    return;
                }
            }
        }
    }

    public char [] changeWord(char[] showingWord) {
        wynik = 1;
        for (int i = 0; i < showingWord.length; i++) {
            if (showingWord[i] == '\u0000' ) {
                showWord[i] = '_';
                wynik = 0;
            } else {
                showWord[i] = showingWord[i];
            }
        }
        return showWord;
    }
}
