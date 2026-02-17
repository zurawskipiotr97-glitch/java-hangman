package pl.edu.agh.hangman;

import java.io.IOException;

public class Api {

    public static void run() throws IOException, InterruptedException {
        Config k = Config.getInstance();
        setConfig(k);
        newGame(k);
        wantANewGame();
    }

    public static void setConfig(Config k) {
        ConfigInputSetter setter = new ConfigInputSetter(k);
        setter.menu();
    }

    //  Main logic
    static void newGame(Config k) throws IOException, InterruptedException {
        CheckLetters gra = new CheckLetters(k);
        gra.prepare();
        PrintBoard print = new PrintBoard(gra, k);

        do {
            print.printBoard(gra);
            if (!print.getEndFlag()) {
                gra.containsLetter(UserInput.letterInput());
            } else {
                break;
            }
        } while ((gra.getGameStatus() != k.getTable().length));
    }

    private static void wantANewGame() throws IOException, InterruptedException {
        WantANewGameInput.decide();
    }
}
