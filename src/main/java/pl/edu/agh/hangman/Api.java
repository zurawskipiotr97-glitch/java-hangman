package pl.edu.agh.hangman;

import java.io.IOException;

public class Api {

    public static void run() throws IOException, InterruptedException {
        Config k = Config.getInstance();
        CheckLetters gra = new CheckLetters();
        PrintBoard print = new PrintBoard(gra);
        String[] table = k.getTable();



//  Main logic
        while (gra.getGameStatus() != table.length + 1) {
            gra.containsLetter(UserInput.letterInput());
            print.printBoard(gra);
        }



    }

}
