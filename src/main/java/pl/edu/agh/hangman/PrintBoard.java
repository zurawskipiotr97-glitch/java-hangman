package pl.edu.agh.hangman;

import java.util.Arrays;

public class PrintBoard {
    Config k = Config.getInstance();
    String[] tablica;
    private char[] showWord;
    private boolean endFlag = false;

    public PrintBoard(CheckLetters gra) {
        this.tablica = k.getTable();;
        this.showWord = new char[gra.getShowingWord().length];
    }

    public void printBoard(CheckLetters gra) {


        if (tablica.length != gra.getGameStatus() + 1) {
            printGame(gra);
// log
            System.out.println(gra.getWord());

            if (Arrays.equals(showWord, gra.getCharWord())) {
                printGame(gra);
                System.out.println("WINNER");
                endFlag = true;
                return;
            }
            return;
        } else {
            printGame(gra);
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

    private void printGame(CheckLetters gra) {
        System.out.println();
        System.out.println(modifyHangmanLine(gra.getGameStatus(),
                3, "       " + toStringWithSpaces(changeWord(gra.getShowingWord()))));
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
