package pl.edu.agh.hangman;

import java.util.Scanner;


public class UserInput {

    private Scanner scanner = new Scanner(System.in);

    public char userInput() {
        String input;
        char character;

        while (true) {
            System.out.print("Enter letter: ");
            input = scanner.nextLine().trim().toUpperCase();

            if (input.length() == 1 && Character.isLetter(input.charAt(0))) {
                character = input.charAt(0);
                character = Character.toUpperCase(character);
                return character;
            }
            System.out.println("Invalid input. Please try again.");
        }

    }
}