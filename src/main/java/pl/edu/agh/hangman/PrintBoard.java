package pl.edu.agh.hangman;

import java.util.Arrays;

public class PrintBoard {
    Config k;
    String[] tablica;
    private final char[] showWord;
    private boolean endFlag = false;

    public PrintBoard(CheckLetters gra, Config k) {
        this.k=k;
        this.tablica = k.getTable();
        this.showWord = new char[gra.getShowingWord().length];
    }

    public void printBoard(CheckLetters gra) {
        if (tablica.length != gra.getGameStatus() + 1) {

            if (Arrays.equals(gra.getShowingWord(), gra.getCharWord())) {
                printGame(gra);
                System.out.println("\n  WINNER\n");
                endFlag = true;
            } else {
                printGame(gra);
                System.out.println("Wrong Letters: " + gra.getWrongLetters());
                System.out.println(gra.getWord());
            }

        } else {
            printEndGame(gra);
            System.out.println("\n  LOOSER\n");
            endFlag = true;
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

    private void printGame(CheckLetters gra) {
        System.out.println();
        System.out.println(modifyHangmanLine(gra.getGameStatus(),
                3, "       " + toStringWithSpaces(changeWord(gra.getShowingWord()))));
    }

    private void printEndGame(CheckLetters gra) {
        System.out.println();
        System.out.println(modifyHangmanLine(gra.getGameStatus(),
                3, "       " + toStringWithSpaces(changeWord(gra.getCharWord()))));
    }

    private static String toStringWithSpaces(char[] wordtoprint) {
        StringBuilder noweSlowo = new StringBuilder();
        for (char c : wordtoprint) {
            noweSlowo.append(c).append(" ");
        }
        return noweSlowo.toString();
    }

    public String modifyHangmanLine(int picIndex, int lineNumber1Based, String toAppend) {
        String pic = tablica[picIndex];
        String[] lines = pic.split("\n", -1);

        int lineIndex = lineNumber1Based - 1; // 3 -> 2

        if (lineIndex < 0 || lineIndex >= lines.length) {
            return pic; // albo rzuć wyjątek
        }

        lines[lineIndex] = lines[lineIndex] + toAppend;

        return String.join("\n", lines);
    }

    public boolean getEndFlag() {
        return endFlag;
    }
}
