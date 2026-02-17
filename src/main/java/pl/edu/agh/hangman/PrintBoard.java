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
        if (showWord == gra.getCharWord()) {
            System.out.println(tablica[gra.getGameStatus()]);
            System.out.println(gra.getWord());
            System.out.println("WINNER");
            return;
        }

        else if (tablica.length != gra.getGameStatus()) {
            System.out.println();
            System.out.println(tablica[gra.getGameStatus()]);
            showWord = changeWord(gra.getShowingWord());
            System.out.println(showWord);
            System.out.println(gra.getWord());
        } else {
            System.out.println("LOOSER");
            }
        }
    }

    public char [] changeWord(char[] showingWord) {
        for (int i = 0; i < showingWord.length; i++) {
            if (showingWord[i] == '\u0000' ) {
                showWord[i] = '_';
            } else {
                showWord[i] = showingWord[i];
            }
        }
        return showWord;
    }
}
