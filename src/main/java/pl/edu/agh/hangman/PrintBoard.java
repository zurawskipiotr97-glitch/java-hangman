package pl.edu.agh.hangman;

import java.util.Arrays;

public class PrintBoard {
    Config k = Config.getInstance();
    String[] tablica;
    private int stanGry;
    private char[] showWord;
    private boolean endFlag = false;

    public PrintBoard(CheckLetters gra) {
        this.stanGry = gra.getGameStatus();
        this.tablica = k.getTable();;
        this.showWord = new char[gra.getShowingWord().length];
    }

    public void printBoard(CheckLetters gra) {


        if (tablica.length != gra.getGameStatus() + 1) {
            System.out.println();
            System.out.println(tablica[gra.getGameStatus()]);
            printWithSpaces(changeWord(gra.getShowingWord()));
// log
            System.out.println(gra.getWord());

            if (Arrays.equals(showWord, gra.getCharWord())) {

                System.out.println();
                System.out.println(tablica[gra.getGameStatus()]);
                printWithSpaces(changeWord(gra.getShowingWord()));
                System.out.println("WINNER");
                endFlag = true;
                return;
            }
            return;
        } else {

            System.out.println();
            System.out.println(tablica[gra.getGameStatus()]);
            printWithSpaces(changeWord(gra.getShowingWord()));
            System.out.println("LOOSER");
            endFlag = true;
            return;
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

    private static void printWithSpaces(char[] wordtoprint) {
        for (int i = 0 ; i < wordtoprint.length; i++) {
            System.out.print(wordtoprint[i] + " ");
        }
        System.out.println();
    }

    public boolean getEndFlag() {
        return endFlag;
    }
}
