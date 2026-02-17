package pl.edu.agh.hangman;

import java.util.Scanner;

public class ConfigInputSetter {
    private final Scanner scanner = new Scanner(System.in);
    private final Config k;

    public ConfigInputSetter(Config k) {
        this.k = k;
    }

    public void menu() {
        while (true) {
            System.out.print("""
                    
                    HANGMAN - (type number)
                    1. Settings - insert 'S'
                    2. Game - insert anything else
                    3. Exit Game - insert 'exit'
                    (In game type: 'menu' to go back here, or 'exit' exit the game)
                    Your choice:\s""");

            String choice = readUpperLine();

            switch (choice) {
                case "EXIT", "3" -> System.exit(0);
                case "S", "1" -> settingsMenu();   // wraca tutaj normalnie
                default -> {
                    System.out.println("\nGood Luck!");
                    return; // start gry (wyjście z menu)
                }
            }
        }
    }

    private void settingsMenu() {
        while (true) {
            System.out.print("\nSettings\n" +
                             "1. Word Length - insert 'L' (actual: " + k.getMindlugoscSlowa() + " - " + k.getMaxdlugoscSlowa() + ")\n" +
                             "2. Word Source - insert 'S' (actual: " + k.getCaseName() + ")\n" +
                             "3. Hangman Animation - insert 'A' (actual: " + k.getTableName() + ")\n" +
                             "4. Back to Menu - insert anything else\n" +
                             "Your choice: ");

            String nextChoice = readUpperLine();

            switch (nextChoice) {
                case "EXIT" -> System.exit(0);
                case "L", "1" -> newDlugoscSlowa();
                case "S", "2" -> wordSourceMenu();
                case "A", "3" -> animationMenu();
                default -> {
                    return; // wróć do głównego menu
                }
            }
        }
    }

    private void wordSourceMenu() {
        while (true) {
            System.out.print("""
                    
                    Word Source
                    1. Default File - insert 'D'
                    2. Own .txt File (choose path) - insert 'O'
                    3. Wordnik - insert 'W'
                    4. Back - insert anything else
                    Your choice:\s""");

            String sourceChoice = readUpperLine();

            switch (sourceChoice) {
                case "EXIT" -> System.exit(0);
                case "D", "1" -> {
                    k.setWhichRandomWordCase(0);
                    return;
                }
                case "O", "2" -> {
                    newFilePathSource();
                    return;
                }
                case "W", "3" -> {
                    k.setWhichRandomWordCase(2);
                    return;
                }
                default -> {
                    return;
                }
            }
        }
    }

    private void animationMenu() {
        while (true) {
            System.out.print("""
                    
                    Animation
                    1. Default - insert 'D'
                    2. New - insert 'N'
                    3. Back - insert anything else
                    Your choice:\s""");

            String animationChoice = readUpperLine();

            switch (animationChoice) {
                case "EXIT" -> System.exit(0);
                case "D", "1" -> {
                    k.setWhichTableAnimation(0);
                    return;
                }
                case "N", "2" -> {
                    k.setWhichTableAnimation(1);
                    return;
                }
                default -> {
                    return;
                }
            }
        }
    }

    public void newDlugoscSlowa() {
        int newMinDlS;
        int newMaxDlS;

        while (true) {
            System.out.print("\nMinimal Word Length (Natural 1..40): ");
            Integer v = readIntLine();
            if (v != null && v >= 1 && v <= 40) {
                newMinDlS = v;
                k.setMinDlugoscSlowa(newMinDlS);
                break;
            }
            System.out.println("Try again - Minimal has to be a Natural from 1 to 40");
        }

        while (true) {
            System.out.println("\nMinimal Word Length (Natural): " + newMinDlS);
            System.out.print("Maximal Word Length (Natural - equal or bigger than minimal, <=40): ");
            Integer v = readIntLine();
            if (v != null && v >= newMinDlS && v <= 40) {
                newMaxDlS = v;
                k.setMaxdlugoscSlowa(newMaxDlS);
                break;
            }
            System.out.println("Try again - Maximal has to be a Natural from 1 to 40 equal or bigger than minimal");
        }
    }

    public void newFilePathSource() {
        k.setWhichRandomWordCase(1);
        System.out.print("\nAdd path to your file (.txt): ");
        String newPath = scanner.nextLine(); // tu celowo nie upper
        k.setOwnPath(newPath);
    }

    // --- helpers ---

    private String readUpperLine() {
        String line = scanner.nextLine();
        return line == null ? "" : line.trim().toUpperCase();
    }

    /**
     * Czyta liczbę z całej linii (bez problemu "nextInt zostawia \\n").
     * Zwraca null, jeśli nie da się sparsować.
     */
    private Integer readIntLine() {
        String s = scanner.nextLine().trim();
        if (s.isEmpty()) return null;
        try {
            return Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return null;
        }
    }
}
