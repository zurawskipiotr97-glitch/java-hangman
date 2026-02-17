package pl.edu.agh.hangman;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ConfigInputSetter {
    Scanner scanner = new Scanner(System.in);
    Config k;

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

            String choice = scanner.nextLine().toUpperCase();
            switch (choice) {
                case "S", "1" -> {
                    System.out.print("\nSettings\n" +
                            "1. Word Length - insert 'L' (actuall: " + k.getMindlugoscSlowa() + " - " + k.getMaxdlugoscSlowa() + ")\n" +
                            "2. Word Source - insert 'S' (actuall: " + k.getCaseName() + ")\n" +
                            "3. Hangman Animation - insert 'A' (actuall: " + k.getTableName() + ")\n" +
                            "4. Back to Menu - insert anything else\n" +
                            "Your choice: ");

                    String nextChoice = scanner.next().toUpperCase();
                    switch (nextChoice) {
                        case "L", "1" -> {
                            newDlugoscSlowa();
                            menu();
                        }
                        case "S", "2" -> {
                            System.out.print("""
                                    
                                    Word Source
                                    1. Default File - insert 'D'
                                    2. Own .txt File (chose path) - insert 'O'
                                    3. Wordnik - insert 'W'
                                    4. Back to Menu - insert anything else
                                    Your choice:\s""");

                            String sourceChoice = scanner.next().toUpperCase();
                            switch (sourceChoice) {
                                case "D", "1" -> {
                                    k.setWhichRandomWordCase(0);
                                    menu();
                                }
                                case "O", "2" -> {
                                    newFilePathSource();
                                    menu();

                                }
                                case "W", "3" -> {
                                    k.setWhichRandomWordCase(2);
                                    menu();
                                }
                                case "EXIT", "4" -> {
                                    System.exit(0);
                                }
                                default -> {
                                    menu();
                                }
                            }

                        }
                        case "A", "3" -> {

                        }
                        case "EXIT", "4" -> {
                            System.exit(0);
                        }
                        default -> {
                            menu();
                        }
                    }
                }

                case "EXIT", "3" -> {
                    System.exit(0);
                }

                default -> {
                    System.out.println("\nGood Luck!\n");
                    return;
                }
            }
        }
    }

    public void newDlugoscSlowa() {
        int newMinDlS = 1;
        int newMaxDlS = 15;
        boolean ok = false;

        do {
            System.out.print("\nMinimal Word Length (Natural): ");
            if (scanner.hasNextInt()) {
                newMinDlS = scanner.nextInt();
                if (newMinDlS > 0 && newMinDlS <=40){
                    k.setMinDlugoscSlowa(newMinDlS);
                    ok = true;
                } else {
                    System.out.println("Try again - Minimal has to be a Natural from 1 to 40");
                }
            } else {
                System.out.println("Try again - Minimal has to be a Natural from 1 to 40");
                scanner.next();
            }
        } while (!ok);

        ok = false;
        do {
            System.out.println("\nMinimal Word Length (Natural): " + newMinDlS);
            System.out.print("Maximal Word Length (Natural - equal or bigger than minimal): ");
            if (scanner.hasNextInt()) {
                newMaxDlS = scanner.nextInt();
                if (newMaxDlS >= newMinDlS && newMaxDlS <=40){
                    k.setMaxdlugoscSlowa(newMaxDlS);
                    ok = true;
                } else {
                    System.out.println("Try again - Maximal has to be a Natural from 1 to 40 " +
                            "equal or bigger than minimal");
                }
            } else {
                System.out.println("Try again - Maximal has to be a Natural from 1 to 40 " +
                        "equal or bigger than minimal");
                scanner.next();
            }
        } while (!ok);
    }



    public void newFilePathSource() {
            k.setWhichRandomWordCase(1);
        System.out.print("\nAdd path to your file (.txt)");
        String newPath = scanner.nextLine();
        k.setOwnPath(newPath);
    }

    public void setAnimation() {

    }

}