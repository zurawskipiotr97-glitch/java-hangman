package pl.edu.agh.hangman;

import java.io.IOException;

public class Api {

    public static void run() throws IOException, InterruptedException {
        setConfig();
        newGame();
//        wantANewGame();

    }

    public static void setConfig() {
//        Config k = Config.getInstance();


    }

    //  Main logic
    private static void newGame() throws IOException, InterruptedException {
        Config k = Config.getInstance();
        CheckLetters gra = new CheckLetters();
        gra.prepare();
        PrintBoard print = new PrintBoard(gra);

        do {
            print.printBoard(gra);
            if (!print.getEndFlag()) {
                gra.containsLetter(UserInput.letterInput());
            } else {
                break;
            }
        } while ((gra.getGameStatus() != k.getTable().length));
    }
}
