package pl.edu.agh.hangman;

public class PrintBoard {
    int stanGry;
    char[]  openWord;
    String[] tablica;

    public PrintBoard(String[] tablica, char[]  openWord) {
        this.stanGry = 1;
        this.tablica = tablica;
        this.openWord = openWord;
    }

    public void printBoard() {
        System.out.println(tablica[stanGry]);


    }
}
