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
            System.out.println(changeWord(gra.getShowingWord()));
            System.out.println(gra.getWord());
            if (Arrays.equals(showWord, gra.getCharWord())) {
                System.out.println();
                System.out.println(tablica[gra.getGameStatus()]);
                System.out.println((changeWord(gra.getShowingWord())));
                System.out.println("WINNER");
                endFlag = true;
                return;
            }
            return;
        } else {
            System.out.println(tablica[gra.getGameStatus()]);
            System.out.println(changeWord(gra.getShowingWord()));
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

    private char[] showWordSpaceAdder(char[] showWord) {
        char [] newShowWord = new char[showWord.length * 2];
        for (int i = 0; i < showWord.length; i += 2){
            newShowWord[i] = showWord[i/2];
            newShowWord[i+1] = ' ';
        }
        return newShowWord;
    }

    public boolean getEndFlag() {
        return endFlag;
    }
}
