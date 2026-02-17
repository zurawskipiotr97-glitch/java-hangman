package pl.edu.agh.hangman;

import java.io.IOException;

public class Api {

    public static void run() throws IOException, InterruptedException {
        Config k = Config.getInstance();
        CheckLetters gra = new CheckLetters();
        PrintBoard print = new PrintBoard(gra);
        gra.prepare();

//  Main logic
        while (gra.getGameStatus() != k.getTable().length + 1) {
            print.printBoard(gra);
            gra.containsLetter(UserInput.letterInput());
        }

        print.printBoard(gra);


    }

}
