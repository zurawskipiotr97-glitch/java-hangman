package pl.edu.agh.hangman;

import java.io.IOException;
import java.util.Scanner;

public class WantANewGameInput {

    public static void decide() throws IOException, InterruptedException {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("""
                1 New Game/Menu - insert anything
                2. Exit Game - insert 'exit'
                Your choice:\s""");

            String decision = scanner.nextLine().toUpperCase();
            switch (decision) {
                case "EXIT", "2" -> {
                    System.exit(0);
                }
                default -> {
                    Api.run();
                }
            }
        }
    }
}
