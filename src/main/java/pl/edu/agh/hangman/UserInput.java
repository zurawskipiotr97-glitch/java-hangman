package pl.edu.agh.hangman;

import java.util.Scanner;


public class UserInput {

    public static char letterInput() {
        Scanner scanner = new Scanner(System.in);
        String input;
        char character;

        while (true) {
            System.out.print("guess> ");
            input = scanner.nextLine().trim().toUpperCase();
            if (input.equalsIgnoreCase("Exit")) {
                System.exit(0);
            }

            if (input.length() == 1 && Character.isLetter(input.charAt(0))) {
                character = input.charAt(0);
                return character;
            }
            System.out.println("Invalid input. Please try again.");
        }
    }
}